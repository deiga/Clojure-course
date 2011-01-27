; ------ Predicates

; Problem 1
(defn generic-doublificate [arg]
  (condp instance? arg
    clojure.lang.PersistentVector (if (empty? arg) nil (map #(* 2 %) arg))
    clojure.lang.PersistentList (if (empty? arg) nil (map #(* 2 %) arg))
    clojure.lang.IPersistentCollection (if (empty? arg) nil true)
    Number  (* 2 arg)
    true))

(generic-doublificate [5 4 2])
(generic-doublificate '(5 4 2))
(generic-doublificate 1) => 2
(generic-doublificate [1 2]) => (2 4)
(generic-doublificate {}) => nil
(generic-doublificate []) => nil
(generic-doublificate {:a 1}) => true

; Problem 2
(defn empty-string? [string]
  (every? whitespace? string))

(defn whitespace? [character]
  (Character/isWhitespace character))

(empty-string? " \t\n\t ") => true
(empty-string? "  \t a")   => false
(empty-string? "")         => true

; Problem 3
(defn monotonic? [sekvenssi]
  (let [])
  (cond
    (< (first sekvenssi) (second sekvenssi))
      (map (fn [x y] (== (+ x 1) y)) sekvenssi (next sekvenssi))
    (> (first sekvenssi) (second sekvenssi))
      (map (fn [x y] (== (- x 1) y)) sekvenssi (next sekvenssi))))

(monotonic? [1 2 3]) => true
(monotonic? [3 2 1]) => true
(monotonic? [3 2 3]) => false