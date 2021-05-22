(ns ui.markdown.goldly.prosemirror-themed
  (:require
   [re-frame.core :as rf]
   [ui.markdown.prosemirror :refer [prosemirror-reagent]]))

; webly brings a css loader
; this css loader is essential for codemirror, because codemirror expects
; that the css theme is loaded before it gets rendered.
; the css loader takes care of that - also if the theme gets changed at runtime

(defn prosemirror-themed [id fun active?]
  (let [theme (rf/subscribe [:css/theme-component :prosemirror])]
    (fn [id fun active?]
      (let [;theme (or @theme "paraiso-dark") ;"(or (:codemirror-theme @settings) "paraiso-dark")
            ;cm-opt-themed (merge cm-opt {:theme theme})
            ]
        [:div.prose
         [prosemirror-reagent id fun active?]]))))



