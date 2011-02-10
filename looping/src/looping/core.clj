(ns looping.core)

;; Problem LR1
(defn power [base exp]
  (let [helper (fn [foo bar baz]
          (if (zero? bar)
            baz
            (recur foo (dec bar) (* foo baz))))]
    (helper base exp 1)))

;; Problem LR2
(defn last-element [a-seq]
  (when-not (empty? a-seq)
    (if (= 1 (count a-seq))
      (first a-seq)
      (recur (drop 1 a-seq)))))

;; Problem LR2
(defn seq= [seq1 seq2]
    (cond
      (and (empty? seq1) (empty? seq2))
        true
      (or (empty? seq1) (empty? seq2))
        false
      (= (first seq1) (first seq2))
        (recur (rest seq1) (rest seq2))
      :else
        false))

(defn find-first-index [pred a-seq]
  ":(")

(defn avg [a-seq]
  ":(")

(defn parity [a-seq]
  ":(")

(defn fast-fibo [n]
  ":(")

(defn cut-at-repetition [a-seq]
  ":(")

;(
