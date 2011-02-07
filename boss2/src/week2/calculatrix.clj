(ns week2.calculatrix)

(defn read-words []
  "Read a line and split it into words. Returns the words as a vector
  of strings."
  (if-let [line (read-line)]
    (vec (.split line "\\s+"))))

(defn string->number [string]
  (try
    (Integer/parseInt string)
    (catch NumberFormatException e nil)))

(defn compute [command args]
  "Takes a command and a sequence of arguments, returns computed value
  or nil if given an unknown command or non-integer operands."
  (let [first-operand (string->number (first args))
        second-operand (string->number (second args))]
    (cond
      (< 2 (count args))
        (str "Too many arguments for command: " command)
      (nil? first-operand)
        (str "Invalid operand: " (first args))
      (nil? second-operand)
        (str "Invalid operand: " (second args))
      (and first-operand second-operand)
        (case command
          "+" (+ first-operand second-operand)
          "*" (* first-operand second-operand)
          "-" (- first-operand second-operand)
          (str "Invalid command: " command)))))

(defn main []
  "This is the driver loop of the calculator. It loops by calling itself recursively."
  (let [words (read-words)
        command (first words)
        arguments (rest words)
        result (compute command arguments)]
    (if (or (= "" command) (nil? command))
      "Exiting Calculatrix"
      (do
        (println "  =>" result)
        (main)))))
