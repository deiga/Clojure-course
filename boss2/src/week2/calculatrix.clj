(ns week2.calculatrix)

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
      (< 2 (count args))
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
        (case command
          "+" (+ first-operand second-operand)
          "*" (* first-operand second-operand)
          "-" (- first-operand second-operand)
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

