(ns functional-programming.core)

;; Problem F1
(defn concat-all [a-seq]
  (reduce concat [] a-seq))

;; Problem F2
(defn string-cat [a-seq]
  (reduce (fn [x y] (str x (str " " y))) a-seq))2

;; Problem F3
(defn seq-length [a-seq]
  ":(")

;; Problem F4
(defn my-reverse [a-seq]
  (reduce conj '() a-seq))

;; Problem F5
(defn insert [a-seq elem]
  ":(")

(defn insertion-sort [a-seq]
  ":(")

;; Problem  F6
(defn seq-min-max [a-seq]
  ":(")

(defn parity [a-seq]
  ":(")

(def my-double
  (constantly ":("))

(def deep-double
  (constantly ":("))

(def my-empty?
  (constantly ":("))

(def find-first
  (constantly ":("))

(def matrix-sum
  (constantly ":("))

(def first-result
  (constantly ":("))

;(
