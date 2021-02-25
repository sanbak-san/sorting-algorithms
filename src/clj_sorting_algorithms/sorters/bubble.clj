(ns clj-sorting-algorithms.sorters.bubble)

(defn bubble [list val]
  (cond
    (empty? list) [val]
    (< val (peek list)) (conj (pop list) val (peek list))
    :else (conj list val)))

(defn bubble-sort [list]
  (let [sorted-list (reduce bubble [] list)]
    (if (= list sorted-list) list
      (recur sorted-list))))

(def l [11 9 31 81 7 0 3])
(println (bubble-sort l))
