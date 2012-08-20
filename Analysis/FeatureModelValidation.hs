
module Analysis.FeatureModelValidation where

import Language.CPP.Syntax
import Analysis.Conditional

import Data.Generics


type Tree a = Cond BExpr (Text a)

---- | Find all of the non-function macro uses.
--findMacros :: Data a => a -> [Macro]
--findMacros = everything (++) (mkQ [] inE `extQ` inD)
--  where 
--    inE (Defined m)   = [m]
--    inE (Macro   m)   = [m]
--    inE e             = []
--    inD (DM Ifdef m)  = [m]
--    inD (DM Ifndef m) = [m]
--    inD d             = []


usesMacro :: Tree a -> Macro -> Bool
usesMacro (IfThen (Var macro) _)        needle = macro == needle
usesMacro (IfThenElse (Var macro) _ _)  needle = macro == needle
usesMacro _                             needle = False

condChild :: Tree a -> [Tree a]
condChild (IfThen _ c) = c
condChild (IfThenElse _ c _) = c

containsMacro :: Data a => a -> Macro -> Bool
containsMacro hay needle = everything (||) (mkQ False inCond) hay
    where 
        inCond :: Tree String -> Bool
        inCond c = c `usesMacro` needle

macroChildren :: Data a => a -> Macro -> [Tree String]
macroChildren tree macro = everything (++) (mkQ [] inCond) tree
    where 
        inCond :: Tree String -> [Tree String]
        inCond c
            | c `usesMacro` macro   = condChild c
            | otherwise             = []

isNested :: [Tree String] -> Macro -> Macro -> Bool
isNested file parent child = any (`containsMacro` child) $ file `macroChildren` parent
