(ns footpad.core)

(defn horizontal-wall [room-width]
  (apply str (repeat (+ room-width 2) "#")))

(defn insert-object-in-line [object x-coord line]
  (apply str (update-in (into [] line) [x-coord] (fn [_] object))))

(defn generate-empty-room [x y]
  (concat
   [(horizontal-wall x)]
   (repeat y (str "#" (apply str (repeat x " ")) "#"))
   [(horizontal-wall x)]))

(defn add-object-to-room [maze [object x-coord y-coord]]
  (update-in 
   maze
   [y-coord]
   #(insert-object-in-line object x-coord %)))

(defn generate-room [x y & objects]
  (reduce add-object-to-room
   (vec (generate-empty-room x y))
   objects))

(defn generate-random-room []
  (let [x (rand-int 20) y (rand-int 20)]
    (generate-room x y)))

(doall (map println (generate-random-room)))