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
  (map first vecs))

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
    (conj [] fst snd thrd)))

(take-3 [1 2 3 4 5]) => [1 2 3]
(take-3 ["Haruki" "Murakami"]) => ["Haruki" "Murakami" nil]

