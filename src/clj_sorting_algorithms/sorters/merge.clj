(ns clj-sorting-algorithms.sorters.merge)

(defn merge [left right]
  (cond
    (empty? left) right                                       ;Als links nil is return rechts
    (empty? right) left                                       ;Als rechts nul is return links
    :else (let [[l1 & l2] left [r1 & r2] right]             ;Default voeg de lists samen in de juiste volgorde
                (if (<= l1 r1) (cons l1 (merge l2 right))
                              (cons r1 (merge left r2))))))

(defn merge-sort [list]
  (if (< (count list) 2) list                                    ;Dit zorgt ervoor dat de recusie eindig is wanneer de lijst kleiner is dan 2
    (let [[left right] (split-at (/ (count list) 2) list)]
      (merge (merge-sort left) (merge-sort right)))))

(def l [11 9 31 81 7 0 3])
(println (merge-sort l))
