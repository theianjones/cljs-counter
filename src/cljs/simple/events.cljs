(ns simple.events
  (:require
   [re-frame.core :as re-frame]
   [simple.db :as db]
   ))

(re-frame/reg-event-db
 ::initialize-db
 (fn [_ _]
   db/default-db))

(re-frame/reg-event-db
 :update-count
 (fn [db [_ new-count]]
   (assoc db :count new-count)))
