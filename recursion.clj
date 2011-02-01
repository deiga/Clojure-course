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
