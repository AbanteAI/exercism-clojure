(ns rotational-cipher)

(defn rotate [text key]
  (apply str
         (map (fn [c]
                (cond
                  (Character/isUpperCase c)
                  (char (+ (mod (+ (- (int c) (int \A)) key) 26) (int \A)))

                  (Character/isLowerCase c)
                  (char (+ (mod (+ (- (int c) (int \a)) key) 26) (int \a)))

                  :else c))
              text)))
