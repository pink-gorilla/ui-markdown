(ns ui.markdown.goldly.css
  ;(:require
  ; [webly.user.css.helper :refer [add-themes]]
  ; [ui.codemirror.theme :as codemirror]
  ; )
  )

(def components
  {:prose    {true ["markdown/prose.css"]}
   :prose-mirror {true ["prosemirror-view/style/prosemirror.css"
                        "prosemirror-menu/style/menu.css"
                        "markdown/prosemirror-gorilla.css"]}

   ;:codemirror 


   #_(add-themes
      {true ["codemirror/lib/codemirror.css"]}
      "codemirror/theme/%s.css"
      codemirror/themes)})

(def config
  {:prose true
   :prose-mirror true})