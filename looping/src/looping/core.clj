(ns looping.core)

;; Problem LR1
(defn power [base exp]
  (let [helper (fn [foo bar]
          (if (zero? bar)
            foo
            (recur (* foo foo) (dec bar))))]
    (helper base exp)))

(defn last-element [a-seq]
  ":(")

(defn seq= [seq1 seq2]
  ":(")

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
