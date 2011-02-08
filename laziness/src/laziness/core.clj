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

(defn super-composite [n]
  ":(")

(defn indexed
  "Maps elements of a sequence from element to [index-in-sequence element]."
  [s]
  (map vector (range) s))

(defn indexes [a-seq]
  ":(")

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
