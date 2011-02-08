(ns laziness.core
  (:use [clojure.java.io :only (reader as-url)]))

(defn url-get [url]
  (with-open [in (reader (as-url url))]
    (doall (line-seq in))))

;; Problem L1
(defn counting-spider [urls]
  (doall (for [url urls]
      (do
        (println (str "Fetching " url))
        (count (url-get url))))))

;; Problem L2
(defn print-squares [up-to]
  (doseq [num (range up-to)]
    (println (* num num))))

;; Problem L3
(defn smallest-divisible []
  (first (filter #(and (zero? (mod % 72)) (zero? (mod % 108))) (rest (range)))))

;; Problem L4
(defn divisible-by-all-under? [number up-to]
  (every? true? (map #(zero? (mod number %)) (range 1 (inc up-to)))))

(defn composite-helper [num up-to]
  (cond
    (divisible-by-all-under? num up-to)
      num
    :else
      (composite-helper (inc num) up-to)))

(defn super-composite [n])

(defn indexed
  "Maps elements of a sequence from element to [index-in-sequence element]."
  [s]
  (map vector (range) s))

;; Problem L5
(defn indexes [a-seq]
  (let [with-indices (indexed a-seq)]
    (map first with-indices)))

(defn inits [a-seq]
  ":(")

(defn sum-halve [a-seq]
  ":(")

(defn nonempty-tails [a-seq]
  ":(")

(defn subseqs [a-seq]
  ":(")

(defn subseq-sum [target a-seq]
  ":(")

;(
