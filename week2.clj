; ------ Predicates

; Problem 1
(defn generic-doublificate [arg]
  (cond
    (and (coll? arg) (empty? arg))
    nil
    (or (pos? arg) (neg? arg))
      (* 2 arg)
      (or (list? arg) (vector? arg))
        ))

(generic-doublificate 5)
(generic-doublificate -5)
(generic-doublificate [])

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
  )

(monotonic? [1 2 3]) => true
(monotonic? [3 2 1]) => true
(monotonic? [3 2 3]) => false