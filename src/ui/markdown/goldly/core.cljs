(ns ui.markdown.goldly.core
  (:require
   [re-frame.core :as rf]
   [pinkie.pinkie :refer-macros [register-component]]
   [ui.markdown.viewer :refer [markdown-viewer]]
   [ui.markdown.goldly.prosemirror-atom :refer [prosemirror-atom]]
   [ui.markdown.goldly.css :as css]))

(register-component :p/markdown markdown-viewer)
(register-component :p/prosemirror prosemirror-atom)

(rf/dispatch [:css/add-components css/components css/config])


