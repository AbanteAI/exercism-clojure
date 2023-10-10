(ns bank-account)
(def account-state (atom {:status :closed :balance 0}))

(defn open-account []
  (reset! account-state {:status :open :balance 0}))

(defn close-account []
  (swap! account-state assoc :status :closed))

(defn get-balance []
  (if (= (:status @account-state) :open)
    (:balance @account-state)
    (throw (Exception. "Account is closed"))))

(defn update-balance [operation amount]
  (if (= (:status @account-state) :open)
    (case operation
      :deposit (swap! account-state update :balance + amount)
      :withdraw (swap! account-state update :balance - amount))
    (throw (Exception. "Account is closed"))))
