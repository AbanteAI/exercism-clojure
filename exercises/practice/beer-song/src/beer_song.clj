(ns beer-song)

(defn verse
  "Returns the nth verse of the song."
  [num]
  (let [bottles (fn [n] (cond
                          (= n 0) "no more"
                          (= n 1) "1"
                          :else (str n)))
        bottles-caps (fn [n] (if (= n 1) "bottle" "bottles"))]
    (str (clojure.string/capitalize (bottles num)) " " (bottles-caps num) " of beer on the wall, "
         (bottles num) " " (bottles-caps num) " of beer.\n"
         (if (= num 0)
           "Go to the store and buy some more, 99 bottles of beer on the wall.\n"
           (str "Take " (if (= num 1) "it" "one") " down and pass it around, "
                (bottles (dec num)) " " (bottles-caps (dec num)) " of beer on the wall.\n")))))

(defn sing
  "Given a start and an optional end, returns all verses in this interval. If
  end is not given, the whole song from start is sung."
  ([start] (sing start 0))
  ([start end]
   (apply str (interpose "\n" (map verse (range start (dec end) -1))))))
