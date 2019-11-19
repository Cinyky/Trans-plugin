package cn.cyy.plugin.trans.view;

import cn.cyy.plugin.trans.constant.Constant;
import com.intellij.ide.util.PropertiesComponent;
import com.intellij.openapi.options.Configurable;
import com.intellij.openapi.options.ConfigurationException;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * 配置有道翻译的Key
 *
 * @author yuyunchen
 * @date 2019/11/19 10:21
 * @email cyy1079276272@163.com
 */
public class Configuration implements Configurable {

    private JPanel root;

    private JTextField appIdField;

    private JPasswordField keyField;


    @Nls(capitalization = Nls.Capitalization.Title)
    @Override
    public String getDisplayName() {
        return "Trans-Config";
    }

    @Nullable
    @Override
    public JComponent createComponent() {
        appIdField.setText(PropertiesComponent.getInstance().getValue(Constant.KEY_APP_ID));
        keyField.setText(PropertiesComponent.getInstance().getValue(Constant.KEY_APP_KEY));
        return root;
    }

    @Override
    public boolean isModified() {
        return true;
    }

    @Override
    public void apply() throws ConfigurationException {
        PropertiesComponent.getInstance().setValue(Constant.KEY_APP_ID, appIdField.getText());
        PropertiesComponent.getInstance().setValue(Constant.KEY_APP_KEY, String.valueOf(keyField.getPassword()));
    }
}
