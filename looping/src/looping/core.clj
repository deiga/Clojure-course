(ns looping.core)

;; Problem LR1
(defn power [base exp]
  (let [helper (fn [foo bar]
          (cond
            (zero? bar)
              1
            (= 1 bar)
              foo
            :else
              (recur (* foo base) (dec bar))))]
    (helper base exp)))

;; Problem LR2
(defn last-element [a-seq]
  (when-not (empty? a-seq)
    (if (= 1 (count a-seq))
      (first a-seq)
      (recur (rest a-seq)))))

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

;; Problem LR4
(defn find-first-index [pred a-seq]
  (let [helper (fn [i s]
                  (cond
                    (empty? s)
                      nil
                    (pred (first s))
                      i
                    :else
                      (recur (inc i) (rest s))))]
    (helper 0 a-seq)))

;; Problem LR5
(defn avg [a-seq]
  (let [helper (fn [s sum]
                  (if (empty? s)
                  (/ sum (count a-seq))
                  (recur (rest s) (+ sum (first s)))))]
    (helper a-seq 0)))

;; Problem LR6
(defn parity [a-seq]
  (let [helper (fn [st sq]
                  (cond
                    (empty? sq)
                      st
                    (contains? st (first sq))
                      (recur (disj st (first sq)) (rest sq))
                    :else
                      (recur (conj st (first sq)) (rest sq))))]
    (helper #{} a-seq)))

;; Problem LR7
(defn fast-fibo [n]
  (loop [k 2
         fu-n 1
         fu-n1 0]
    (cond
      (zero? n)
        0
      (= 1 n)
        1
      (= k n)
        (+ fu-n fu-n1)
      :else
        (recur (inc k) (+ fu-n fu-n1) fu-n))))

;; Problem LR8
(defn cut-at-repetition [a-seq]
  ":(")

;(
