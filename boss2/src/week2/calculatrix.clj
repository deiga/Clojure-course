(ns week2.calculatrix)

(def function-table {"+" (fn [& args] (apply + args))
                     "*" (fn [& args] (apply * args))
                     "-" (fn [& args] (apply - args))
                     "avg" (fn [& args] (/ (apply + args) 2))
                     "pow" (fn [b e] (int (Math/pow b e)))})

(defn read-words []
  "Read a line and split it into words. Returns the words as a vector
  of strings. Loops until a line is available."
  (if-let [line (read-line)]
    (vec (.split line "\\s+"))
    (recur)))

(defn string->number [string]
  (try
    (Integer/parseInt (str string))
    (catch NumberFormatException e nil)
    ))

(defn compute [command args store & [last-result]]
  "Takes a command and a sequence of arguments, returns computed value
  or nil if given an unknown command or non-integer operands."
  (let [fst (first args)
        snd (second args)
        first-operand (string->number fst)
        second-operand (string->number snd)]
    (cond
      (and (< 2 (count args)) (= "pow" command));;(or (> 2 (count args)) (< 2 (count args)))
        (conj () store (str "Wrong number of arguments to " command ": expects 2, you gave " (count args) "."))
      (= "store" command)
        (if (nil? second-operand)
          (conj () (conj store [fst (store snd)]) nil)
          (conj () (conj store [fst second-operand]) nil))
      (and (nil? first-operand) (not (= "_" fst)) (not (contains? store fst)))
        (conj () store (str "Invalid operand: " fst))
      (and (nil? second-operand) (not (= "_" snd)) (not (contains? store snd)))
        (conj () store (str "Invalid operand: " snd))
      (= "_" fst)
        (compute command (conj [] last-result snd) store)
      (= "_" snd)
        (compute command (conj [] fst last-result) store)
      (contains? store fst)
        (compute command (conj [] (store fst) snd) store)
      (contains? store snd)
        (compute command (conj [] fst (store snd)) store)
      (and first-operand second-operand)
        (if (contains? function-table command)
          (conj () store (apply (function-table command) (map string->number args)))
          (conj () store (str "Invalid command: " command))))))

(defn main-helper [[last-result store]]
  (let [words (read-words)
        command (first words)
        arguments (rest words)
        result (compute command arguments store last-result)]
    (if (or (= "" command) (nil? command))
      "Exiting Calculatrix"
      (do
        (println "  =>" (first result))
        (main-helper result)))))

(defn main []
  "This is the driver loop of the calculator. It loops by calling itself recursively."
  (main-helper [0 {}]))


