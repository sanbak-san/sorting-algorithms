(ns clj-sorting-algorithms.sorters.insert)

(defn insert [list position]
  (let [current (get list position)]                        ;Met let wordt er een binding gemaakt van de huidige waarde
    (loop [i position item list]
      (let [left (get item (dec i))]
        (if (and (> i 0) (< current left))
          (recur (dec i) (assoc item i left))               ;If true schuif current naar links
          (assoc item i current))))))                       ;Else kan waarde toe aan current

(defn insertion-sort [list]
  (let [length (-> list count)]                             ;Er wordt een binding gemaakt van de grootte van de list
    (loop [i 1 sorted-list list]                            ;Een loop over de gehele list, startend bij index 1
      (if (<= i (- length 1))
        (recur (inc i) (insert sorted-list i))              ;Voer insert uit voor ieder getal in de list
        sorted-list))))

(def l [11 9 31 81 7 0 3])
(println (insertion-sort l))
