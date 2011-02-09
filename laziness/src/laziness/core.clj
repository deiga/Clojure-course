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
  (= up-to (count (filter #(zero? (mod number %)) (range 1 (inc up-to))))));;(not (some false? (map #(zero? (mod number %)) (range 1 (inc up-to))))))

(defn super-composite [n]
  (first (filter #(divisible-by-all-under? % n) (rest (range)))))

(defn indexed
  "Maps elements of a sequence from element to [index-in-sequence element]."
  [s]
  (map vector (range) s))

;; Problem L5
(defn indexes [a-seq]
  (let [with-indices (indexed a-seq)]
    (map first with-indices)))

;; Problem L6
(defn inits [a-seq]
  (conj (map (fn [x y] (take x a-seq)) (rest (range)) a-seq) ()));;(repeat (inc (count a-seq)) a-seq)))

;; Problem L7
(defn halves [a-seq]
  (map (fn [x y] (vector (take x a-seq) (drop x a-seq))) (rest (range)) a-seq))

(defn sum-halve [a-seq]
  (first (filter #(= (apply + (first %)) (apply + (second %))) (halves a-seq))))

;; Problem L8
(defn nonempty-tails [a-seq]
  (map (fn [x y] x) (iterate rest a-seq) a-seq))

;; Problem L9
(defn subseqs [a-seq]
  (mapcat nonempty-tails (inits a-seq)))

(defn subseq-sum [target a-seq]
  ":(")

;(
