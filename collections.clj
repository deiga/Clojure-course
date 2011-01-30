; Problem C1

(defn doublificate [str-to-num]
  (let [keys-to-add (map #(str "double-" %) (keys str-to-num))
        vals-to-add (map #(* 2 %) (vals str-to-num))
        mapped-addition (zipmap keys-to-add vals-to-add)]
    (merge-with + str-to-num mapped-addition)))

(doublificate {"a" 1 "b" 7}) => {"a" 1 "double-a" 2 "b" 7 "double-b" 14}

; Problem C2
(defn halve [input]
  )

(halve [1 2 3 4])   => [(1 2) (3 4)]
(halve [1 2 3 4 5]) => [(1 2 3) (4 5)]