; ------ Predicates

; Problem P1
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

; Problem P2
(defn empty-string? [string]
  (every? whitespace? string))

(defn whitespace? [character]
  (Character/isWhitespace character))

(empty-string? " \t\n\t ") => true
(empty-string? "  \t a")   => false
(empty-string? "")         => true

; Problem P3
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

; Problem P4
(def books [{:author "China Miéville" :title "Kraken"}
            {:author "China Miéville" :title "The City and the City"}
            {:author "Haruki Murakami" :title "Norwegian Wood"}
            {:author "Guy Gavriel Kay" :title "Under Heaven"}])

(def books2 (load-file "books.clj"))

(defn every-book-has-a-title? [books-coll]
  (every? :title books-coll))
(every-book-has-a-title? books) => true

; Problem P5
(defn first-value-for-key [key maps]
  (some key maps))

(first-value-for-key :a [{:b 1 :c 2} {:a 1 :b 2} {:a 2}])  => 1
(first-value-for-key :a [{:b 1 :c 2} {:c 3}])              => nil

; Problem P6
(defn prime? [num]
  (let [p (fn [x] (== (mod num x) 0))]
      (not (some p (range 2 num)))))


(prime? 4) => false  ;; or nil
(prime? 17) => true  ;; some other true-ish value is okay too
(prime? 2)
(prime? 3)
(prime? 5)
(prime? 11)