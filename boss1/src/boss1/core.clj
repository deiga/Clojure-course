(ns boss1.core)

(def books (load-file "books.clj"))


(defn author-has-years? [book]
  (let [author (book :author)]
    (or (contains? author :birth-year) (contains? author :death-year))))

(defn books-with-author-years [books]
  (filter #(author-has-years? %) books))

(defn authors [books]
  (distinct (map :author books)))

(defn author-names [books]
  (distinct (map #(:name (:author %)) books)))

(defn titles-by-author [author books]
  (map :title (filter #(= author (:author %)) books)))

(defn author-catalog [books]
  (reduce conj {} (map #(conj [] % (titles-by-author % books)) (authors books))))
