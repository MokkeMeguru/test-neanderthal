(ns test-neanderthal.core
  (:require
   [uncomplicate.neanderthal.core :refer :all]
   [uncomplicate.neanderthal.native :refer :all]
   [uncomplicate.neanderthal.linalg :refer :all]))

;; ------------------------------------------------------------
;; sample1
(def a (dge 2 3 [1 2 3 4 5 6]))
;; #RealGEMatrix[double, mxn:2x3, layout:column, offset:0]
;; ▥       ↓       ↓       ↓       ┓
;; →       1.00    3.00    5.00
;; →       2.00    4.00    6.00
;; ┗                               ┛

(def b (dge 3 2 [1 3 5 7 9 11]))
;; #RealGEMatrix[double, mxn:3x2, layout:column, offset:0]
;; ▥       ↓       ↓       ┓
;; →       1.00    7.00
;; →       3.00    9.00
;; →       5.00   11.00
;; ┗                       ┛

(mm a b)
;; #RealGEMatrix[double, mxn:2x2, layout:column, offset:0]
;; ▥       ↓       ↓       ┓
;; →      35.00   89.00
;; →      44.00  116.00
;; ┗                       ┛

;; ------------------------------------------------------------
;; sample2
(def A (dge 3 2 [1 0 1 1 1 2]))

(def or (qrfp A))
;; #RealGEMatrix[double, mxn:3x2, layout:column, offset:0]
;; ▥       ↓       ↓       ┓
;; →       1.41    2.12
;; →      -0.00    1.22
;; →      -2.41    3.15
;; ┗                       ┛

(def r (dge 2 2 (:or or)))
;; #RealGEMatrix[double, mxn:2x2, layout:column, offset:0]
;; ▥       ↓       ↓       ┓
;; →       1.41    2.12
;; →      -0.00    1.22
;; ┗                       ┛

(def q (org or))
;; #RealGEMatrix[double, mxn:3x2, layout:column, offset:0]
;; ▥       ↓       ↓       ┓
;; →       0.71   -0.41
;; →       0.00    0.82
;; →       0.71    0.41
;; ┗                       ┛

(def b (dge 3 1 [1 0 -2]))

(def x (mm (tri (trf r)) (trans q) b))
;; #RealGEMatrix[double, mxn:2x1, layout:column, offset:0]
;; ▥       ↓       ┓
;; →       1.00
;; →      -1.00
;; ┗               ┛

;; ------------------------------------------------------------
;; sample2 ~another solution~
(def A (dge 3 2 [1 0 1 1 1 2]))

(def b (dge 3 1 [1 0 -2]))

(def x_ (dge 2 1 (ls A b)))
;; #RealGEMatrix[double, mxn:2x1, layout:column, offset:0]
;; ▥       ↓       ┓
;; →       1.00
;; →      -1.00
;; ┗               ┛
