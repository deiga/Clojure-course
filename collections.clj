; Problem C1

(defn doublificate [str-to-num]
  (let [tmp (map #(str "double-" %) (keys str-to-num))]
    tmp))

(doublificate {"a" 1 "b" 7}) => {"a" 1 "double-a" 2 "b" 7 "double-b" 14}