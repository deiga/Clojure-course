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

(defn compute [command args & [last-result]]
  "Takes a command and a sequence of arguments, returns computed value
  or nil if given an unknown command or non-integer operands."
  (let [first-operand (string->number (first args))
        second-operand (string->number (second args))]
    (cond
      (and (< 2 (count args)) (= "pow" command));;(or (> 2 (count args)) (< 2 (count args)))
        (str "Wrong number of arguments to " command ": expects 2, you gave " (count args) ".")
      (and (nil? first-operand) (not (= "_" (first args))))
        (str "Invalid operand: " (first args))
      (and (nil? second-operand) (not (= "_" (second args))))
        (str "Invalid operand: " (second args))
      (= "_" (first args))
        (compute command (conj [] last-result second-operand))
      (= "_" (second args))
        (compute command (conj [] first-operand last-result))
      (and first-operand second-operand)
        (if (contains? function-table command)
          (apply (function-table command) (map string->number args))
          (str "Invalid command: " command)))))

(defn main [& [last-result]]
  "This is the driver loop of the calculator. It loops by calling itself recursively."
  (let [words (read-words)
        command (first words)
        arguments (rest words)
        result (compute command arguments last-result)]
    (if (or (= "" command) (nil? command))
      "Exiting Calculatrix"
      (do
        (println "  =>" result)
        (main result)))))

