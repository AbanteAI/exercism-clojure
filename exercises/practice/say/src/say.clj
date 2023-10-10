(ns say)

(defn number [num]
  (let [ones ["zero" "one" "two" "three" "four" "five" "six" "seven" "eight" "nine"]
        teens ["ten" "eleven" "twelve" "thirteen" "fourteen" "fifteen" "sixteen" "seventeen" "eighteen" "nineteen"]
        tens ["twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"]
        scales ["thousand" "million" "billion"]
        num-to-words (fn [n]
          (cond
            (< n 0) (str "negative " (num-to-words (- n)))
            (< n 10) (ones n)
            (< n 20) (teens (- n 10))
            (< n 100) (str (tens (quot (- n 20) 10)) (if (mod n 10) (str "-" (ones (mod n 10))) ""))
            (< n 1000) (str (ones (quot n 100)) " hundred" (if (mod n 100) (str " and " (num-to-words (mod n 100))) ""))
            :else (loop [remaining n
                         scale 0
                         result ""]
                   (if (< remaining 1000)
                     (str result (num-to-words remaining))
                     (recur (quot remaining 1000)
                            (inc scale)
                            (str result (num-to-words (mod remaining 1000)) " " (scales scale) " "))))))]
  (if (<= 0 num 999999999999)
    (num-to-words num)
    (throw (IllegalArgumentException. "Number out of range"))))
        tens ["twenty" "thirty" "forty" "fifty" "sixty" "seventy" "eighty" "ninety"]
        scales ["thousand" "million" "billion"]
        (defn num-to-words [n]
          (cond
            (< n 0) (str "negative " (num-to-words (- n)))
            (< n 10) (ones n)
            (< n 20) (teens (- n 10))
            (< n 100) (str (tens (quot (- n 20) 10)) (if (mod n 10) (str "-" (ones (mod n 10))) ""))
            (< n 1000) (str (ones (quot n 100)) " hundred" (if (mod n 100) (str " and " (num-to-words (mod n 100))) ""))
            :else (loop [remaining n
                         scale 0
                         result ""]
                   (if (< remaining 1000)
                     (str result (num-to-words remaining))
                     (recur (quot remaining 1000)
                            (inc scale)
                            (str result (num-to-words (mod remaining 1000)) " " (scales scale) " "))))))]
  (if (<= 0 num 999999999999)
    (num-to-words num)
    (throw (IllegalArgumentException. "Number out of range"))))
