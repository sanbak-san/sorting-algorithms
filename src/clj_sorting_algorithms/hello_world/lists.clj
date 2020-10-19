(ns clj-sorting-algorithms.hello-world.lists)

(def l ["a" "b" 9 8 88])

(defn print-list [list]
  (run! println list))

(print-list l)
