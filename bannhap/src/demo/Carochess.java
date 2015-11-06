/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo;

import dungchung.Oco;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Stack;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author PC
 */
public class Carochess extends JPanel {

    public enum KetThuc {

        HoaCo,
        Player1,
        Player2,
        COM
    };

    public static ImageIcon imageO;

    public static ImageIcon getImageO() {
        return imageO;
    }

    public static void setImageO(ImageIcon imageO) {
        Carochess.imageO = imageO;
    }
    public static ImageIcon imageX;

    public static ImageIcon getImageX() {
        return imageX;
    }

    public static void setImageX(ImageIcon imageX) {
        Carochess.imageX = imageX;
    }
    public static ImageIcon imageBanCo;
    private boolean _SanSang;
    private BanCo _BanCo;

    public BanCo getBanCo() {
        return _BanCo;
    }

    public void setBanCo(BanCo _BanCo) {
        this._BanCo = _BanCo;
    }
    private Oco[][] _MangOCo;

    public Oco getMangOCo(int i,int j) {
        return _MangOCo[i][j];
    }

    public void setMangOCo(Oco[][] _MangOCo) {
        this._MangOCo = _MangOCo;
    }
    private int _LuotDi;

    public int getLuotDi() {
        return _LuotDi;
    }

    public void setLuotDi(int _LuotDi) {
        this._LuotDi = _LuotDi;
    }
    private int _CheDoChoi;

    public int getCheDoChoi() {
        return _CheDoChoi;
    }

    public void setCheDoChoi(int _CheDoChoi) {
        this._CheDoChoi = _CheDoChoi;
    }

    private Stack<Oco> stk_CacNuocDaDi;
    private KetThuc _KetThuc;

    public Carochess() {

        _BanCo = new BanCo(20, 20);
        _MangOCo = new Oco[_BanCo.getSoDong()][_BanCo.getSoCot()];
        imageO = new ImageIcon(getClass().getResource("/Image/o.png"));
        imageX = new ImageIcon(getClass().getResource("/Image/x.png"));
        imageBanCo = new ImageIcon(getClass().getResource("/Image/banco_fix.png"));
        _LuotDi = 1;
        stk_CacNuocDaDi = new Stack<Oco>();
        eBoard = new EvalBoard();
    }

    public void KhoiTaoMangOCo() {
        for (int i = 0; i < _BanCo.getSoDong(); i++) {
            for (int j = 0; j < _BanCo.getSoCot(); j++) {
                _MangOCo[i][j] = new Oco(i, j, new Point(j * 25, i * 25), 0);
            }
        }
    }

    public boolean DanhCo(int MouseX, int MouseY, Graphics g) {
        //if(MouseX % 25 == 0 || MouseY % 25 == 0)
        //   return false;
        int Cot = (MouseX) / 25;
        int Dong = (MouseY) / 25;
        if (_MangOCo[Dong][Cot].getSohuu() != 0) {
            return false;
        }
        if (_SanSang == false) 
            return false;
        switch (_LuotDi) {
            case 1:
                _MangOCo[Dong][Cot].setSohuu(1);
                _BanCo.VeQuanCo(g, _MangOCo[Dong][Cot].getVitri(), imageO);
                _LuotDi = 2;
                break;
            case 2:
                _MangOCo[Dong][Cot].setSohuu(2);
                _BanCo.VeQuanCo(g, _MangOCo[Dong][Cot].getVitri(), imageX);
                _LuotDi = 1;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Co loi");
                break;
            
        }
        Oco oco = new Oco(_MangOCo[Dong][Cot].getDong(), _MangOCo[Dong][Cot].getCot(), _MangOCo[Dong][Cot].getVitri(), _MangOCo[Dong][Cot].getSohuu());
        stk_CacNuocDaDi.push(oco);
        return true;
    }
    
    public boolean DanhCo_CS(int MouseX, int MouseY, Graphics g) {
        //if(MouseX % 25 == 0 || MouseY % 25 == 0)
        //   return false;
        int Cot = (MouseX) / 25;
        int Dong = (MouseY) / 25;
        if (_MangOCo[Dong][Cot].getSohuu() != 0) {
            return false;
        }
        if (_SanSang == false) 
            return false;
        switch (_LuotDi) {
            case 1:
                _MangOCo[Dong][Cot].setSohuu(1);
                //_BanCo.VeQuanCo(g, _MangOCo[Dong][Cot].getVitri(), imageO);
                _LuotDi = 2;
                break;
            case 2:
                _MangOCo[Dong][Cot].setSohuu(2);
                //_BanCo.VeQuanCo(g, _MangOCo[Dong][Cot].getVitri(), imageX);
                _LuotDi = 1;
                break;
            default:
                JOptionPane.showMessageDialog(null, "Co loi");
                break;
            
        }
        Oco oco = new Oco(_MangOCo[Dong][Cot].getDong(), _MangOCo[Dong][Cot].getCot(), _MangOCo[Dong][Cot].getVitri(), _MangOCo[Dong][Cot].getSohuu());
        stk_CacNuocDaDi.push(oco);
        return true;
    }

    public void VeLaiQuanCo(Graphics g) {
        Iterator it = stk_CacNuocDaDi.iterator();
        while (it.hasNext()) {
            Oco oco = (Oco) it.next();
            if (oco.getSohuu() == 1) {
                _BanCo.VeQuanCo(g, oco.getVitri(), imageO);
            } else if (oco.getSohuu() == 2) {
                _BanCo.VeQuanCo(g, oco.getVitri(), imageX);
            }

        }
    }
// <editor-fold desc="Duyet_Chien_Thang">

    public void ThongBao() {
        switch (_KetThuc) {
            case HoaCo: {
                JOptionPane.showMessageDialog(null, "Hòa Cờ");
                break;
            }
            case Player1: {
                Winner win = new Winner(null, true);
                win.setVisible(true);
                break;
            }
            case Player2: {
                JOptionPane.showMessageDialog(null, "Player 2 Win");
                break;
            }
            case COM: {
                JOptionPane.showMessageDialog(null, "COM Win");
                break;
            }
        }
        _SanSang = false;
    }

    public boolean KiemTraChienThang() {
        if (stk_CacNuocDaDi.size() == _BanCo.getSoCot() * _BanCo.getSoDong()) {
            _KetThuc = KetThuc.HoaCo;
            return true;
        }

        Iterator it = stk_CacNuocDaDi.iterator();
        while (it.hasNext()) {
            Oco oco = (Oco) it.next();
            if (DuyetDoc(oco.getDong(), oco.getCot(), oco.getSohuu()) || DuyetNgang(oco.getDong(), oco.getCot(), oco.getSohuu()) || DuyetCheoXuoi(oco.getDong(), oco.getCot(), oco.getSohuu()) || DuyetCheoNguoc(oco.getDong(), oco.getCot(), oco.getSohuu())) {
                _KetThuc = oco.getSohuu() == 1 ? KetThuc.Player1 : KetThuc.Player2;
                return true;
            }
        }
        return false;
    }
    
    public void Undo(Graphics g){
        if(stk_CacNuocDaDi.size() !=0){
            Oco oco=stk_CacNuocDaDi.pop();
            _MangOCo[oco.getDong()][oco.getCot()].setSohuu(0);
            System.out.println(oco.getCot() +"-"+ oco.getDong());
            paint(g);
            if(_LuotDi == 1)
                _LuotDi = 2;
            else
                _LuotDi = 1;
        }
    }

    private boolean DuyetDoc(int curDong, int curCot, int curSohuu) {
        if (curDong > _BanCo.getSoDong() - 5) {
            return false;
        }
        int Dem;
        for (Dem = 1; Dem < 5; Dem++) {
            if (_MangOCo[curDong + Dem][curCot].getSohuu() != curSohuu) {
                return false;
            }
        }
        if (curDong == 0 || curDong + Dem == _BanCo.getSoDong()) {
            return true;
        }
        if (_MangOCo[curDong - 1][curCot].getSohuu() == 0 || _MangOCo[curDong + Dem][curCot].getSohuu() == 0) {
            return true;
        }
        return false;
    }

    private boolean DuyetNgang(int curDong, int curCot, int curSohuu) {
        if (curCot > _BanCo.getSoCot() - 5) {
            return false;
        }
        int Dem;
        for (Dem = 1; Dem < 5; Dem++) {
            if (_MangOCo[curDong][curCot + Dem].getSohuu() != curSohuu) {
                return false;
            }
        }
        if (curCot == 0 || curCot + Dem == _BanCo.getSoCot()) {
            return true;
        }
        if (_MangOCo[curDong][curCot - 1].getSohuu() == 0 || _MangOCo[curDong][curCot + Dem].getSohuu() == 0) {
            return true;
        }
        return false;
    }

    private boolean DuyetCheoXuoi(int curDong, int curCot, int curSohuu) {
        if ((curCot > _BanCo.getSoCot() - 5) || (curDong > _BanCo.getSoDong() - 5)) {
            return false;
        }
        int Dem;
        for (Dem = 1; Dem < 5; Dem++) {
            if (_MangOCo[curDong + Dem][curCot + Dem].getSohuu() != curSohuu) {
                return false;
            }
        }

        if (curDong == 0 || curDong + Dem == _BanCo.getSoDong() || curCot == 0 || curCot + Dem == _BanCo.getSoCot()) {
            return true;
        }
        if (_MangOCo[curDong - 1][curCot - 1].getSohuu() == 0 || _MangOCo[curDong + Dem][curCot + Dem].getSohuu() == 0) {
            return true;
        }
        return false;
    }

    private boolean DuyetCheoNguoc(int curDong, int curCot, int curSohuu) {
        if (curCot > _BanCo.getSoCot() - 5 || curDong < 4) {
            return false;
        }
        int Dem;
        for (Dem = 1; Dem < 5; Dem++) {
            if (_MangOCo[curDong - Dem][curCot + Dem].getSohuu() != curSohuu) {
                return false;
            }
        }
        if (curDong == 4 || curDong == _BanCo.getSoDong() - 1 || curCot == 0 || curCot + Dem == _BanCo.getSoCot()) {
            return true;
        }
        if (_MangOCo[curDong + 1][curCot - 1].getSohuu() == 0 || _MangOCo[curDong - Dem][curCot + Dem].getSohuu() == 0) {
            return true;
        }
        return false;
    }
// </editor-fold>

    public void StartPvsP(Graphics g) {
        _SanSang = true;
        stk_CacNuocDaDi = new Stack<Oco>();
        _LuotDi = 1;
        KhoiTaoMangOCo();
        paint(g);
    }

    public void StartPvcC(Graphics g) {
        _SanSang = true;
        stk_CacNuocDaDi = new Stack<Oco>();
        _LuotDi = 1;
        _CheDoChoi = 2;
        KhoiTaoMangOCo();
        paint(g);
        KhoiDongComputer(g);
    }
// <editor-fold desc="AI">
    EvalBoard eBoard;
    int playerFlag = 2; //Biến cờ xác định máy đi hay người đi.
    int _x, _y; //Tọa độ nước cờ mà máy đi.

    public static int maxDepth = 11;
    public static int maxMove = 3;
    public int depth = 0;

    public boolean fWin = false;
    public int fEnd = 1;

    public int DScore[] = {0, 1, 9, 81, 729};

    //public int[] AScore = new int[5] { 0, 3, 24, 243, 2197 };
    public int AScore[] = {0, 2, 18, 162, 1458};

        //public int[] AScore = new int[5] { 0, 1, 9, 81, 729 };
    Point[] PCMove = new Point[maxMove + 2];
    Point[] HumanMove = new Point[maxMove + 2];
    //Point[] WinMove = new Point[maxDepth+2];
    Point[] LoseMove = new Point[maxDepth + 2];
    ArrayList<Point> WinMove = new ArrayList<Point>(maxDepth + 2);

    //Ham tinh gia tri cho bang luong gia
    private void EvalChessBoard(int player, EvalBoard eBoard) {
        int rw, cl, ePC, eHuman;
        eBoard.ResetBoard();

        //Danh gia theo hang
        for (rw = 0; rw < _BanCo.getSoDong(); rw++) {
            for (cl = 0; cl < _BanCo.getSoCot() - 4; cl++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (_MangOCo[rw][cl + i].getSohuu() == 1) {
                        eHuman++;
                    }
                    if (_MangOCo[rw][cl + i].getSohuu() == 2) {
                        ePC++;
                    }
                }

                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (_MangOCo[rw][cl + i].getSohuu() == 0) // Neu o chua duoc danh
                        {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    eBoard.EBoard[rw][cl + i] += DScore[ePC];
                                } else {
                                    eBoard.EBoard[rw][cl + i] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    eBoard.EBoard[rw][cl + i] += DScore[eHuman];
                                } else {
                                    eBoard.EBoard[rw][cl + i] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                eBoard.EBoard[rw][cl + i] *= 2;
                            }
                        }
                    }

                }
            }
        }

        //Danh gia theo cot
        for (cl = 0; cl < _BanCo.getSoCot(); cl++) {
            for (rw = 0; rw < _BanCo.getSoDong() - 4; rw++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (_MangOCo[rw + i][cl].getSohuu() == 1) {
                        eHuman++;
                    }
                    if (_MangOCo[rw + i][cl].getSohuu() == 2) {
                        ePC++;
                    }
                }

                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (_MangOCo[rw + i][cl].getSohuu() == 0) // Neu o chua duoc danh
                        {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    eBoard.EBoard[rw + i][cl] += DScore[ePC];
                                } else {
                                    eBoard.EBoard[rw + i][cl] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    eBoard.EBoard[rw + i][cl] += DScore[eHuman];
                                } else {
                                    eBoard.EBoard[rw + i][cl] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                eBoard.EBoard[rw + i][cl] *= 2;
                            }
                        }
                    }

                }
            }
        }

        //Danh gia duong cheo xuong
        for (cl = 0; cl < _BanCo.getSoCot() - 4; cl++) {
            for (rw = 0; rw < _BanCo.getSoDong() - 4; rw++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (_MangOCo[rw + i][cl + i].getSohuu() == 1) {
                        eHuman++;
                    }
                    if (_MangOCo[rw + i][cl + i].getSohuu() == 2) {
                        ePC++;
                    }
                }

                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (_MangOCo[rw + i][cl + i].getSohuu() == 0) // Neu o chua duoc danh
                        {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    eBoard.EBoard[rw + i][cl + i] += DScore[ePC];
                                } else {
                                    eBoard.EBoard[rw + i][cl + i] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    eBoard.EBoard[rw + i][cl + i] += DScore[eHuman];
                                } else {
                                    eBoard.EBoard[rw + i][cl + i] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                eBoard.EBoard[rw + i][cl + i] *= 2;
                            }
                        }
                    }

                }
            }
        }

        //Danh gia duong cheo len
        for (rw = 4; rw < _BanCo.getSoDong(); rw++) {
            for (cl = 0; cl < _BanCo.getSoCot() - 4; cl++) {
                ePC = 0;
                eHuman = 0;
                for (int i = 0; i < 5; i++) {
                    if (_MangOCo[rw - i][cl + i].getSohuu() == 1) {
                        eHuman++;
                    }
                    if (_MangOCo[rw - i][cl + i].getSohuu() == 2) {
                        ePC++;
                    }
                }

                if (eHuman * ePC == 0 && eHuman != ePC) {
                    for (int i = 0; i < 5; i++) {
                        if (_MangOCo[rw - i][cl + i].getSohuu() == 0) // Neu o chua duoc danh
                        {
                            if (eHuman == 0) {
                                if (player == 1) {
                                    eBoard.EBoard[rw - i][cl + i] += DScore[ePC];
                                } else {
                                    eBoard.EBoard[rw - i][cl + i] += AScore[ePC];
                                }
                            }
                            if (ePC == 0) {
                                if (player == 2) {
                                    eBoard.EBoard[rw - i][cl + i] += DScore[eHuman];
                                } else {
                                    eBoard.EBoard[rw - i][cl + i] += AScore[eHuman];
                                }
                            }
                            if (eHuman == 4 || ePC == 4) {
                                eBoard.EBoard[rw - i][cl + i] *= 2;
                            }
                        }
                    }

                }
            }
        }

    }

    //Ham tim nuoc di cho may
    private void FindMove() {
        if (depth > maxDepth) {
            return;
        }
        depth++;
        fWin = false;
        boolean fLose = false;
        Point pcMove = new Point();
        Point humanMove = new Point();
        int countMove = 0;

        EvalChessBoard(2, eBoard);

        //Lay ra MaxMove buoc di co diem cao nhat
        Point temp = new Point();
        for (int i = 0; i < maxMove; i++) {
            temp = eBoard.MaxPos();
            PCMove[i] = temp;
            eBoard.EBoard[temp.x][temp.y] = 0;
        }

        //Lay nuoc di trong PCMove[] ra danh thu
        countMove = 0;
        while (countMove < maxMove) {

            pcMove = PCMove[countMove++];
            _MangOCo[pcMove.x][pcMove.y].setSohuu(2);
            WinMove.add(depth - 1, pcMove);
                //WinMove.

            //Tim cac nuoc di toi uu cua nguoi
            eBoard.ResetBoard();
            EvalChessBoard(1, eBoard);
            //Lay ra maxMove nuoc di co diem cao nhat cua nguoi
            for (int i = 0; i < maxMove; i++) {
                temp = eBoard.MaxPos();
                HumanMove[i] = temp;
                eBoard.EBoard[temp.x][temp.y] = 0;
            }
            //Danh thu cac nuoc di
            for (int i = 0; i < maxMove; i++) {
                humanMove = HumanMove[i];
                _MangOCo[humanMove.x][humanMove.y].setSohuu(1);
                if (KiemTraChienThang() == true && _KetThuc == KetThuc.Player2) {
                    fWin = true;
                    //MessageBox.Show("fwin" + fWin.ToString());
                }
                if (KiemTraChienThang() == true && _KetThuc == KetThuc.Player1) {
                    fLose = true;
                    //MessageBox.Show("flose" + fLose.ToString());
                }
                if (fLose) {
                    _MangOCo[pcMove.x][pcMove.y].setSohuu(0);
                    _MangOCo[humanMove.x][humanMove.y].setSohuu(0);
                    break;
                }
                if (fWin) {
                    _MangOCo[pcMove.x][pcMove.y].setSohuu(0);
                    _MangOCo[humanMove.x][humanMove.y].setSohuu(0);
                    return;
                }
                FindMove();
                _MangOCo[humanMove.x][humanMove.y].setSohuu(0);
            }
            _MangOCo[pcMove.x][pcMove.y].setSohuu(0);

        }

    }

    private void AI() {
        for (int i = 0; i < maxMove; i++) {
            //System.out.print(maxDepth);
            WinMove.add(i, new Point());
            PCMove[i] = new Point();
            HumanMove[i] = new Point();
        }
        depth = 0;
        FindMove();
        //MessageBox.Show(depth.ToString());
    }

// </editor-fold>
    public void KhoiDongComputer(Graphics g) {
        if (stk_CacNuocDaDi.size() == 0) {
            DanhCo(_BanCo.getSoCot() / 2 * 25 + 1, _BanCo.getSoDong() / 2 * 25 + 1, g);
        } else {
            Oco oco = MayDanh();
            DanhCo(oco.getVitri().x, oco.getVitri().y, g);
        }
    }

    public Oco MayDanh() {

        AI();
        if (fWin) {
            _x = WinMove.get(0).x;
            _y = WinMove.get(0).y;
        } else {
            EvalChessBoard(2, eBoard);
            Point temp = new Point();
            temp = eBoard.MaxPos();
            _x = temp.x;
            _y = temp.y;
        }
        System.out.println(_x + "," + _y);
        //_MangOCo[_x][_y].setSohuu(2);
        Oco oco2 = new Oco(_MangOCo[_x][_y].getDong(), _MangOCo[_x][_y].getCot(), _MangOCo[_x][_y].getVitri(), _MangOCo[_x][_y].getSohuu());
        return oco2;
    }

    @Override
    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(imageBanCo.getImage(), 0, 0, this);
        VeLaiQuanCo(g);
    }
}
