package com.andreesperanca.estudia.models

sealed class ControlPanelScreenState {
    object Study: ControlPanelScreenState()
    object ShortPause: ControlPanelScreenState()
    object LongPause: ControlPanelScreenState()
}

