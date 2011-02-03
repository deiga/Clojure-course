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