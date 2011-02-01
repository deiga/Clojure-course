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