(ns wordy)
(defn tokenize [input]
  (clojure.string/split input #"\s+"))

(defn parse [tokens]
  (loop [tokens tokens
         operations []]
    (if (empty? tokens)
      operations
      (let [token (first tokens)]
        (cond
          (re-matches #"^-?\d+$" token)
          (recur (rest tokens) (conj operations (Integer/parseInt token)))

          (= token "plus")
          (recur (rest tokens) (conj operations +))

          (= token "minus")
          (recur (rest tokens) (conj operations -))

          (= token "multiplied")
          (recur (rest (rest tokens)) (conj operations *))

          (= token "divided")
          (recur (rest (rest tokens)) (conj operations /))

          :else
          (recur (rest tokens) operations))))))

(defn evaluate
  ([]
   (evaluate ""))
  ([input]
   (if (clojure.string/blank? input)
     nil
     (let [tokens (tokenize input)
           operations (parse tokens)]
       (loop [ops operations
              result 0]
         (if (empty? ops)
           result
           (let [op (first ops)]
             (if (fn? op)
               (recur (rest ops) (op result (first (rest ops))))
               (recur (rest ops) op)))))))))
(defn evaluate [] ;; <- arglist goes here
      ;; your code goes here
)
