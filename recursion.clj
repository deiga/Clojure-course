; Problem R1
(defn product [coll]
  (if (empty? coll)
    1
    (* (first coll) (product (rest coll)))))

(product [])        => 1  ;; special case
(product [1 2 3])   => 6
(product [1 2 3 4]) => 24
(product [0 1 2])   => 0
(product #{2 3 4})  => 24 ;; works for sets too!
(product '(1 2 3 4))
(product nil)

; Problem R2
(product '(1 2 3 4))
=  (* (cons 1 (cons 2 (cons 3 (cons 4 nil)))))
=> (* 1 (product (cons 2 (cons 3 (cons 4 nil)))))
=> (* 1 (* 2 (product (cons 3 (cons 4 nil)))))
=> (* 1 (* 2 (* 3 (product (cons 4 nil)))))
=> (* 1 (* 2 (* 3 (* 4 (product nil)))))
=> (* 1 (* 2 (* 3 (* 4 1))))        ; (empty? nil) is true, so (product nil) => 1
=> (* 1 (* 2 (* 3 4)))
=> (* 1 (* 2 12))
=> (* 1 24)
=> 24

; Problem R3
(defn last-element [sequence]
  (when-not (empty? sequence)
    (if (== 1 (count sequence))
      (first sequence)
      (last-element (rest sequence)))))

(last-element [1 2 3]) => 3
(last-element [2 5])   => 5

; Problem R4
(defn sequence-contains? [value sequence]
  (if (empty? sequence)
    false
    (if (= value (first sequence))
      true
      (sequence-contains? value (rest sequence)))))

(sequence-contains? 3 [1 2 3]) => true
(sequence-contains? 3 [4 7 9]) => false
(sequence-contains? :pony [])  => false

; Problem R5
(defn seq= [compare to]
  (if (and (empty? compare) (empty? to))
    true
    (if (or (empty? compare) (empty? to))
      false
      (if (= (first compare) (first to))
        (seq= (rest compare) (rest to))
        false))))

(seq= [1] '(1))
(seq= [] '())
(seq= [1 2 4] '(1 2 4))  => true
(seq= [1 2 3] [1 2 3 4]) => false
(seq= [1 3 5] [])        => false

; Problem R6
(defn power [n k]
  (if (== 0 k)
    1
    (* n (power n (dec k)))))

(power 2 2) => 4
(power 5 3) => 125
(power 7 0) => 1
(power 0 10) => 0

; Problem R7
(defn fib [nth-number]
  (if (= 0 nth-number)
    nth-number
    (if (= 1 nth-number)
      nth-number
      (+ (fib (dec nth-number)) (fib (- nth-number 2))))))

(fib 0) => 0
(fib 1) => 1
(fib 2) => 1
(fib 3) => 2
(fib 4) => 3
(fib 5) => 5
(fib 6) => 8
(fib 10) => 55

; Problem R8
(defn my-range [up-to]
  (if (= 0 up-to)
    nil
    (cons (dec up-to) (my-range (dec up-to)))))

(my-range 0)  => nil
(my-range 1)  => (0)
(my-range 2)  => (1 0)
(my-range 3)  => (2 1 0)

; Problem R9
(defn map-1 [func arg]
  (if (empty? arg)
    ()
    (cons (func (first arg)) (map-1 func (rest arg)))))

(map-1 identity [])                 => ()
(map-1 identity [1 2 3])            => (1 2 3)
(map-1 count ["aaa" "bb" "cccc"])   => (3 2 4)
(map-1 first [[1 2] [4] [7 12 28]]) => (1 4 7)
(map-1 zero? [0 2 0 13 4 0])        => (true false true false false true)
(map-1 #(cons (first%) (rest %)) [1 2 3 4])

(defn snip-many [sq]
  (conj [] (take-while number? sq) (drop-while #(= :snip %) (drop-while number? sq))))

(snip-many [1 2 3])
  => ((1 2 3))
(snip-many [])
  => (())
(snip-many [:snip 1 2 :snip 3 :snip])
  => (() (1 2) (3) ())
(snip-many [:snip])
  => (() ())

; Problem R11
(defn tails [sequence]
  (if (empty? sequence)
    [()]
    (cons (seq sequence) (tails (rest sequence)))))

(defn inits [sequence]
  (if (empty? sequence)
    [()]
    (cons (seq sequence) (inits (drop-last sequence)))))


(tails [1 2 3 4])   => ((1 2 3 4) (2 3 4) (3 4) (4) ())
(inits [1 2 3 4])   => (() (1) (1 2) (1 2 3) (1 2 3 4))
(inits [1 2 3 4])   => ((1 2) () (1 2 3) (1) (1 2 3 4))

; Problem R12
(defn monotonic-prefix [sequence]
  (let [asc (map <= sequence (next sequence))
      desc (map >= sequence (next sequence))
      asc-true (take-while #(= true %) asc)
      desc-true (take-while #(= true %) desc)
      asc-count (count asc-true)
      desc-count (count desc-true)]
      (if (> asc-count desc-count)
        (take (inc asc-count) sequence)
        (take (inc desc-count) sequence))))

(defn split-into-monotonic [sequence]
  (when-not (empty? sequence)
    (let [mons (monotonic-prefix sequence)]
      (cons mons (split-into-monotonic (drop (count mons) sequence))))))

(split-into-monotonic [0 1 2])
(split-into-monotonic [0 1 2 1 0])   => ((0 1 2) (1 0))
(split-into-monotonic [0 5 4 7 1 3]) => ((0 5) (4 7) (1 3))

; Problem R13
(defn rotate-helper [sq rots]
  (if (= 0 rots)
    ()
    (cons (seq sq) (rotate-helper (cons (last sq) (drop-last sq)) (dec rots)))))

(defn rotations [sq]
  (rotate-helper sq (count sq)))

(rotations [])      => ()
(rotations [1 2 3]) => ((1 2 3) (2 3 1) (3 1 2))
(rotations [:a :b]) => ((:a :b) (:b :a))

; Problem R14
(defn frequencies-helper [freqs coll]
  (if (empty? coll)
    freqs
    (if (find freqs (first coll))
      (frequencies-helper (update-in freqs [(first coll)] inc) (rest coll))
      (frequencies-helper (assoc freqs (first coll) 1) (rest coll)))))


(defn my-frequencies [coll]
  (frequencies-helper {} coll))

(my-frequencies []) => {}
(my-frequencies [:a "moi" :a "moi" "moi" :a 1]) => {:a 3, "moi" 3, 1 1}

; Problem R15
(defn un-helper [outp coll]
  (if (empty? coll)
    outp
    (un-helper (concat outp (repeat (val (first coll)) (key (first coll)))) (rest coll))))

(defn un-frequencies [coll]
  (un-helper () coll))

(un-frequencies {:a 3 :b 2 "^_^" 1})    => (:a :a :a "^_^" :b :b)
(un-frequencies (my-frequencies [:a :b :c :a])) => (:a :a :b :c)
(my-frequencies (un-frequencies {:a 100 :b 10})) => {:a 100 :b 10}

; Problem R16
(defn seq-merge-helper [outp sq1 sq2]
  (cond
    (zero? (count sq1))
      (concat outp sq2)
    (zero? (count sq2))
      (concat outp sq1)
    (> (first sq1) (first sq2))
      (seq-merge-helper (conj outp (first sq2)) sq1 (rest sq2))
    (< (first sq1) (first sq2))
      (seq-merge-helper (conj outp (first sq1)) (rest sq1) sq2)
    (= (first sq1) (first sq2))
      (seq-merge-helper (conj outp (first sq1) (first sq2)) (rest sq1) (rest sq2))))


(defn seq-merge [sq1 sq2]
  (seq-merge-helper [] sq1 sq2))

(seq-merge [4] [1 2 6 7])        => (1 2 4 6 7)
(seq-merge [1 5 7 9] [2 2 8 10]) => (1 2 2 5 7 8 9 10)

; Problem R17
(defn mergesort [sq]
  (let [[head & tail] sq]
    (if (nil? tail)
      sq
      (let [[left right] (split-at (/ (count sq) 2) sq)]
        (seq-merge (merge-sort left) (merge-sort right))))))

(mergesort [])                 => ()
(mergesort [1 2 3])            => (1 2 3)
(mergesort [5 3 4 17 2 100 1]) => (1 2 3 4 5 17 100)
