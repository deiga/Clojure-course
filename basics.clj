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
  (cond (== (mod nr 15) 0) (print "gotcha") (== (mod nr 5) 0) (print "buzz") (== (mod nr 3) 0) (print "fizz")))

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
  (if (<= 13 age 19)
    true
    false))

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