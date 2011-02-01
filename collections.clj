; Problem C1

(defn doublificate [str-to-num]
  (let [keys-to-add (map #(str "double-" %) (keys str-to-num))
        vals-to-add (map #(* 2 %) (vals str-to-num))
        mapped-addition (zipmap keys-to-add vals-to-add)]
    (merge str-to-num mapped-addition)))

(doublificate {"a" 1 "b" 7}) => {"a" 1 "double-a" 2 "b" 7 "double-b" 14}

; Problem C2
(defn halve [input]
  (let [half (/ (count input) 2)]
  (split-at half input)))
  ;(conj [] (take half input) (drop half input))))

(halve [1 2 3 4])   => [(1 2) (3 4)]
(halve [1 2 3 4 5]) => [(1 2 3) (4 5)]

; Problem C3
(defn first-five-positives [sequence]
  (take 5 (filter pos? sequence)))

(first-five-positives [1 3 -2 3 2 0 10 -1 42]) => (1 3 3 2 10)
(first-five-positives [1 -2 9 -4 -5])          => (1 9)

; Problem C4
(defn snip [sequence]
  (conj [] (take-while number? sequence) (drop-while keyword? (drop-while number? sequence))))

(snip [1 4 2 :snip 8 2 9]) => [(1 4 2) (8 2 9)]

; Problem C5
(defn describe-books [book-map]
  (let [number (count book-map)
        fst-str (str "I have " number " books.")]
      (str fst-str (apply str (map (fn [x] (str " " (:title x) " was written by " (:author x) ".")) book-map)))))

(describe-books [{:title "Fooled by Randomness" :author "Nassim Taleb"} {:title "In Cold Blood" :author "Truman Capote"}])
=>
"I have 2 books. Fooled by Randomness was written by Nassim Taleb. In Cold Blood was written by Truman Capote."

; Problem C6
(defn monotonic? [sequence]
  (let [asc (map <= sequence (next sequence))
        desc (map >= sequence (next sequence))
        asc-false (filter #(= false %) asc)
        desc-false (filter #(= false %) desc)]
    (or (= 0 (count asc-false)) (= 0 (count desc-false)))))

(monotonic? [1 2 3])    => true
(monotonic? [0 1 10 11]) => true
(monotonic? [3 2 0 -3]) => true
(monotonic? [3 2 2])    => true  ; Not strictly monotonic
(monotonic? [1 2 1 0])  => false

; Problem C7
(defn transpose [vecs]
  (apply map list vecs)))

(transpose [[1 2 3]
            [4 5 6]
            [7 8 9]
            [0 0 0]])
    => ((1 4 7 0)
        (2 5 8 0)
        (3 6 9 0))
(transpose []) => ()
(transpose [[1 2 3]]) => ((1) (2) (3))

; Problem C8
(defn exterminate [number-map]
  (apply dissoc number-map (filter #(> % (get number-map %)) (keys number-map))))

(exterminate {}) => {}
(exterminate {3 2, 5 1}) => {}
(exterminate {1 3, 4 2, 5 7, 10 9, 8 8}) => {1 3, 5 7, 8 8}

; Problem C9
(defn take-3 [coll]
  (let [[fst snd thrd] coll]
    [fst snd thrd]))

(take-3 [1 2 3 4 5]) => [1 2 3]
(take-3 ["Haruki" "Murakami"]) => ["Haruki" "Murakami" nil]

; Problem C10
(defn my-keys [a-map]
  (for [[fst & rest] (seq a-map)]
    fst))

(my-keys {:name "Doyle, Arthur Conan, Sir" :birth-year 1859, :death-year 1930})
    => (:name :birth-year :death-year)
(my-keys {:title "Norwegian Wood" :author "Haruki Murakami"})
    => (:title :author)

; Problem C11
(defn author-to-string [author-map]
  (let [{name :name
         birth :birth-year
         death :death-year} author-map]
    (str name " (" birth "-" death ")")))

(author-to-string {:name "Shakespeare, William", :birth-year 1564, :death-year 1616})
    => "Shakespeare, William (1564-1616)"
(author-to-string {:name "Doyle, Arthur Conan, Sir", :birth-year 1859, :death-year 1930})
    => "Doyle, Arthur Conan, Sir (1859-1930)"

; Problem C12
(defn book-to-string [{title :title, author :author}]
  (str "A book, " title ", written by " (author-to-string author)))

(book-to-string {:title "Nuoren Robertin matka Grönlantiin isäänsä hakemaan"
                 :author {:name "Hoffmann, Franz", :birth-year 1814, :death-year 1882}})
    => "A book, Nuoren Robertin matka Grönlantiin isäänsä hakemaan, written by Hoffmann, Franz (1814-1882)"

; Problem C13
(defn who-wrote [bookshelf index]
  (:author (nth bookshelf index)))

(who-wrote [{:author "Me" :title "Best Book"} {:author "Sam" :title "This Other Book"}] 1)
  => "Sam"

; Problem C14
(defn author-birth-years [books-coll]
  (map #(:birth-year (:author %)) (filter #(:birth-year (:author %)) books-coll)))

(def books [{:author {:name "Haruki Murakami"
                      :birth-year 1949}
             :title "Norwegian Wood"}
            {:author {:name "David Mitchell"}
             :title "The Thousand Autumns of Jacob de Zoet"}
            {:author {:name "Guy Gavriel Kay"
                      :birth-year 1954}
             :title "Under Heaven"}])

(author-birth-years books) => (1949 1954)

; Problem C15
(defn add-at [matrix a b]
  (update-in matrix a #(+ % (get-in matrix b))))

(add-at [[1 2 3]
         [4 5 6]
         [7 8 9]]
        [1 1]
        [2 1])
    => [[1 2  3]
        [4 13 6]
        [7 8  9]]

; Problem C16
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

(monotonic-prefix [1 2 3 1]) => (1 2 3)
(monotonic-prefix [1 3 10 9 2]) => (1 3 10)
(monotonic-prefix [3 2 3 1]) => (3 2)
(monotonic-prefix [7 6 1 0 10]) => (7 6 1 0)