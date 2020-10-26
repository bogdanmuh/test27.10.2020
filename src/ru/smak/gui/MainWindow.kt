package ru.smak.gui

import ru.smak.gui.components.ControlPanel
import ru.smak.gui.components.GraphicsPanel
import ru.smak.gui.graphics.CartesianPainter
import ru.smak.gui.graphics.NewtonPainter
import ru.smak.gui.graphics.convertation.CartesianScreenPlane
import ru.smak.gui.graphics.convertation.Converter
import ru.smak.polynoms.Newton
import java.awt.Color
import java.awt.Dimension
import java.awt.event.*
import javax.swing.GroupLayout
import javax.swing.JFrame

class MainWindow : JFrame(){// aбскратный класс для создание окошек

    private val minSize = Dimension(550, 400)
    private val mainPanel: GraphicsPanel
    private val controlPanel: ControlPanel

    private val newton = Newton(mutableMapOf())
    init{
        defaultCloseOperation = EXIT_ON_CLOSE// при нажатие  на крестик прога закрываеться
        minimumSize = Dimension(minSize.width+200, minSize.height+400)// why
        mainPanel = GraphicsPanel()
        mainPanel.background = Color.WHITE
        controlPanel = ControlPanel()
        val gl = GroupLayout(contentPane)// contentPane

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addGap(4)
                .addComponent(mainPanel, minSize.height, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                .addGap(4)
                .addComponent(controlPanel, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(4)
        )
        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addGap(4)
                .addGroup(
                        gl.createParallelGroup()
                                .addComponent(mainPanel, minSize.width, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                                .addComponent(controlPanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE)
                )
                .addGap(4))
        layout = gl
        pack()
        val plane = CartesianScreenPlane(
                mainPanel.width, mainPanel.height,
                controlPanel.smXMin.number.toDouble(),
                controlPanel.smXMax.number.toDouble(),
                controlPanel.smYMin.number.toDouble(),
                controlPanel.smYMax.number.toDouble()
        )

        val dp = CartesianPainter(plane)

        val NewtonP = NewtonPainter(plane,newton)

        mainPanel.addComponentListener(object : ComponentAdapter() {
            override fun componentResized(e: ComponentEvent?) {
                dp.plane.realWidth=mainPanel.width
                NewtonP.plane.realWidth=mainPanel.width

                dp.plane.realHeight=mainPanel.height
                NewtonP.plane.realHeight=mainPanel.height

                mainPanel.repaint()
            }
        })
        mainPanel.addMouseListener(object : MouseAdapter(){
            override fun mouseClicked(e: MouseEvent?) {
                super.mouseClicked(e)
                if(e!=null){
                    //проверка на клик по панели mainPanel
                    if(e.point.x < plane.realWidth && e.point.x > 0 && e.point.y > 0 && e.point.y < plane.realHeight ){
                        //добавление в полином точек
                        newton.addNote(Converter.xScr2Crt(e.point.x,plane),Converter.yScr2Crt(e.point.y,plane))
                        mainPanel.repaint()
                    }
                }
            }
        })
        controlPanel.addValChangeListener {
            dp.plane.xMin = controlPanel.smXMin.number.toDouble()
            NewtonP.plane.xMin = controlPanel.smXMin.number.toDouble()

            dp.plane.xMax = controlPanel.smXMax.number.toDouble()
            NewtonP.plane.xMax = controlPanel.smXMax.number.toDouble()

            dp.plane.yMin = controlPanel.smYMin.number.toDouble()
            NewtonP.plane.yMin = controlPanel.smYMin.number.toDouble()

            dp.plane.yMax = controlPanel.smYMax.number.toDouble()
            NewtonP.plane.yMin = controlPanel.smYMin.number.toDouble()

            mainPanel.repaint()
        }
        mainPanel.addPainter(dp)
        mainPanel.addPainter(NewtonP)
    }
}