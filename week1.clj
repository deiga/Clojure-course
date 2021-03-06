; -------- Prefix --------

; Problem 1
(+ 2 2)
(+ 2 2 2 3)
(* 2 (+ 3 4 (- (* 2 2))))

; Problem 2
(mod 5 (inc 2))

; Problem 3
(subs "abcdefg" (count "hij") (+ 3 (mod 6 4)))

; -------- Basics --------

; Testing
(println "Hello, World" "Durr")

(defn hello-world [name]
  (str "Hello, " name))

(hello-world "Pera Seinäjoelta")

; Problem 1
(defn square [number]
  (* number number))

(square 2)
(square 3)

; Problem 2
(defn first-half [word]
  (subs word 0 (/ (count word) 2)))

(doc subs)
(count "foof")
(/ 2 (count "foof"))
(/ (count "foof") 2)
(first-half "foof")
(first-half "!")
(first-half "o'rly")
(first-half "1234567")

; Problem 3
(defn rectangle-area [width height]
  (* width height))

(rectangle-area 5 5)
(rectangle-area 1 42)
(rectangle-area 0 5)
(rectangle-area -3 2)

; Problem 4
(defn avg [fst snd]
  (/ (+ fst snd) 2))

(avg 5 3)
(avg 5 4)
(avg 10 10)

; Problem 5
(defn abs [number]
  (if (< number 0)
    (* -1 number)
    number))

(abs -5)
(abs 0)
(abs 14)

; Problem 6
(defn fizzbuzz [nr]
  (cond
    (== (mod nr 15) 0)
      (print "gotcha")
    (== (mod nr 5) 0)
      (print "buzz")
    (== (mod nr 3) 0)
      (print "fizz")))

(fizzbuzz 45)
  ; "gotcha"nil
(fizzbuzz 48)
  ; "fizz"nil
(fizzbuzz 70)
  ; "buzz" nil

; Problem 7
(defn foo [x]
  (if x
    "true"
    "false"))

(foo 42)
  ;=> "true"
(foo [])
  ;=> "true"
(foo "")
  ;=> "true"
(foo true)
  ;=> "true"
(foo nil)
  ;=> "false"
(foo false)
  ;=> "false"

; Problem 8
(defn teen? [age]
  (<= 13 age 19))

(teen? 12)
(teen? 15)
(teen? 13)
(teen? 19)
(teen? 27)

; Problem 9
(defn not-teen? [age]
  (not (teen? age)))

(not-teen? 13)
(not-teen? 25)
(not-teen? 12)

; Problem 10
(defn spiff [vector]
  (+ (nth vector 0) (nth vector 2)))

(spiff  [1 2 3])
(spiff  [1 2])
  ;=> nil
(spiff  '(1 2 3))
  ;=> 4

; Problem 11
(defn cutefy [collection]
  (conj collection "<3"))

(cutefy  [1 2 3])
(cutefy '(1 2 3))

; Problem 12
(defn spiff2 [collection]
  (let [fst (nth collection 0)
        snd (nth collection 2)]
      (+ fst snd)))

(spiff2 [1 2 3])
(spiff2 [1 2])
  ;=> nil
(spiff2 '(1 2 3))
  ;=> 4

; Problem 13
(def cities {:author "China Miéville" :title "The City and the City"})
(defn title-length [book]
  (let [title (book :title)
        title-length (count title)]
    title-length))

(title-length cities)

; Problem 14
(def books {{:author "China Miéville" :title "The City and the City"} 500
            {:author "Haruki Murakami" :title "Norwegian Wood"} 400
            {:author "Guy Gavriel Kay" :title "Under Heaven"} 576})

(defn add-number-of-pages [book-map book]
  (let [nr-of-pages (book-map book)]
    (assoc book :number-of-pages nr-of-pages)))

(add-number-of-pages books cities)

; Problem 15
(defn first-elems [vects]
  (for [vect vects]
    (nth vect 0)))

(first-elems [[1 2 3] [4 5 6]])

; Problem 16
(defn sort-by-keys [map]
  (let [keys (keys map)
        sorted (sort keys)]
    (for [key sorted]
      (get map key))))

(keys  { "b" 1 "c" 2 "a" 3 })
(sort (keys  { "b" 1 "c" 2 "a" 3 }))
(sort-by-keys { "b" 1 "c" 2 "a" 3 })

; Problem 17
(defn books-by-author [author list-of-books]
  (for [book list-of-books
        :when (= (book :author) author)]
    (book :title)))


(def books [{:author "China Miéville" :title "Kraken"}
            {:author "China Miéville" :title "The City and the City"}
            {:author "Haruki Murakami" :title "Norwegian Wood"}
            {:author "Guy Gavriel Kay" :title "Under Heaven"}])
(books-by-author "China Miéville" books)

; Problem 18
(defn books-by-author2 [author list-of-books]
  (map :title (filter (fn [x] (= (x :author) author)) list-of-books)))

(books-by-author2 "China Miéville" books)

; Problem 19
(defn maps-and-filters [seqs]
  (map #(nth % 1) seqs))

(maps-and-filters [[1 2 3] [4 5 6 7] [8 9]])

; Problem 20
(defn str-to-seq [string]
  (map #(Integer. (str %))
          (filter #(Character/isDigit %) string)))

(str-to-seq "1,2,3,4,5")

; Problem 21
(defn consecutives [seq]
  (map vector seq (next seq)))

(map + [1 2 3] [4 5 6])
(consecutives [1 2 3 4])