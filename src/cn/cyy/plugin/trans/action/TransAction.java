package cn.cyy.plugin.trans.action;

import cn.cyy.plugin.trans.constant.Constant;
import cn.cyy.plugin.trans.customize.BallonUtils;
import cn.cyy.plugin.trans.entity.TransObj;
import cn.cyy.plugin.trans.utils.HttpUtil;
import com.google.gson.Gson;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.PlatformDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.editor.SelectionModel;
import org.apache.http.util.TextUtils;

public class TransAction extends AnAction {

    private final String ERROR_STR = "未查询到结果";

    @Override
    public void actionPerformed(AnActionEvent e) {
        // TODO: insert action logic here
//        Messages.showMessageDialog("测试插件!", "错误", Messages.getErrorIcon());
        final Editor mEditor = e.getData(PlatformDataKeys.EDITOR);
        if (null == mEditor) {
            return;
        }
        SelectionModel model = mEditor.getSelectionModel();
        final String selectedText = model.getSelectedText();
        if (TextUtils.isEmpty(selectedText)) {
            return;
        }
        String response = HttpUtil.doGet(Constant.baseUrl + selectedText);
        if (TextUtils.isEmpty(response)) {
            return;
        }
        TransObj transObj = new Gson().fromJson(response, TransObj.class);
        String s = String.format("【词典】  %s \r\n 【结果】 %s \r\n 【释义】 %s ",
                transObj.getQuery(),
                transObj.getTranslation() == null ? ERROR_STR : transObj.getTranslation(),
                transObj.getBasic() == null ? ERROR_STR : (transObj.getBasic().getExplains() == null ? ERROR_STR : transObj.getBasic().getExplains()));
        BallonUtils.showPopupBalloon(mEditor, s);
    }


}
