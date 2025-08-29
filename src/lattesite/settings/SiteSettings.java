package lattesite.settings;

import lattesite.localization.locale.Locale;
import lattesite.utils.StringUtil;

import java.util.List;

public class SiteSettings {

    private final List<Locale> locales;

    private String publicFolder;
    private String staticRootFolder;
    private String staticLocaleFolder;

    public SiteSettings(
            Locale locale
    ) {
        this(List.of(locale));
    }

    public SiteSettings(
            List<Locale> locales
    ) {
        this.locales = locales;
        this.publicFolder = "public/";
        this.staticRootFolder = "static_root/";
        this.staticLocaleFolder = "static_locale/";
    }

    public List<Locale> getLocales() {
        return this.locales;
    }

    public String getPublicFolder() {
        return publicFolder;
    }

    public String getStaticRootFolder() {
        return this.staticRootFolder;
    }

    public String getStaticLocaleFolder() {
        return this.staticLocaleFolder;
    }

    public void setPublicFolder(String publicFolder) throws Exception {
        if (StringUtil.isEmpty(publicFolder)) {
            throw new Exception("Public folder cannot be empty.");
        }
        this.publicFolder = publicFolder;
    }

    public void setStaticLocaleFolder(String staticLocaleFolder) throws Exception {
        if (StringUtil.isEmpty(staticLocaleFolder)) {
            throw new Exception("Static locale folder cannot be empty.");
        }
        this.staticLocaleFolder = staticLocaleFolder;
    }

    public void setStaticRootFolder(String staticMainFolder) throws Exception {
        if (StringUtil.isEmpty(staticMainFolder)) {
            throw new Exception("Static root folder cannot be empty.");
        }
        this.staticRootFolder = staticMainFolder;
    }

}
