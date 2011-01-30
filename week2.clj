; ------ Predicates

; Problem 1
(defn generic-doublificate [arg]
  (condp instance? arg
    clojure.lang.PersistentVector (if (empty? arg) nil (map #(* 2 %) arg))
    clojure.lang.PersistentList (if (empty? arg) nil (map #(* 2 %) arg))
    clojure.lang.IPersistentCollection (if (empty? arg) nil true)
    Number  (* 2 arg)
    true))


(generic-doublificate 1)        => 2
(generic-doublificate [1 2])    => (2 4)
(generic-doublificate '(65 21)) => (130 42)
(generic-doublificate {})       => nil
(generic-doublificate [])       => nil
(generic-doublificate {:a 1})   => true

; Problem 2
(defn empty-string? [string]
  (every? whitespace? string))

(defn whitespace? [character]
  (Character/isWhitespace character))

(empty-string? " \t\n\t ") => true
(empty-string? "  \t a")   => false
(empty-string? "")         => true

; Problem 3
(defn pred-and [fst snd]
  (fn [x] (and (fst x) (snd x))))

(def pos-even? (pred-and even? pos?)) ; here we give the name pos-even? to the function returned by pred-and
(pos-even? 12) => true

(filter (pred-and even? pos?) [-2 5 12 20]) => (12 20) ; 12 and 20 are the only positive even numbers in the sequence

(def has-title-and-author? (pred-and :title :author))
(has-title-and-author? {:author "China Miéville" :title "The City and the City"})
    => "China Miéville" ; The value returned by :author
(has-title-and-author? {:title "Author unknown"})
    => nil ; Since :author returns nil