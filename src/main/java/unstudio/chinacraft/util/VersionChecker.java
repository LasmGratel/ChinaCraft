package unstudio.chinacraft.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.Loader;
import cpw.mods.fml.common.event.FMLInterModComms;
import org.apache.commons.io.IOUtils;

import unstudio.chinacraft.common.ChinaCraft;

public class VersionChecker implements Runnable {
    private static boolean isLatestVersion = true;
    private static boolean isCheckable = false;
    private static String newVersionInfo = "";
    private static String downloadUrl = "";
    private static int latestVersion = 1;

    @Override
    public void run() {

        InputStream version, info, downloadUrl;
        try {
            version = new URL("http://www.mccraft.cn/mod.php?mod=chinacraft&id=0").openStream();
            info = new URL("http://www.mccraft.cn/mod.php?mod=chinacraft&id=1").openStream();
            downloadUrl = new URL("http://www.mccraft.cn/mod.php?mod=chinacraft&id=3").openStream();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return;
        } catch (FileNotFoundException e){
            System.out.println("[ChinaCraft]Remote Updata Server Has Closed");
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }
        try {
            latestVersion = Integer.valueOf(IOUtils.readLines(version).get(0));
            VersionChecker.newVersionInfo = IOUtils.readLines(info).get(0);
            VersionChecker.downloadUrl = IOUtils.readLines(downloadUrl).get(0);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        } finally {
            IOUtils.closeQuietly(version);
        }
        VersionChecker.isCheckable = true;
        System.out.println("[ChinaCraft]Latest mod version = " + latestVersion);
        isLatestVersion = latestVersion <= ChinaCraft.OutPutVERSION;
        if (ChinaCraft.VersionCheckerIsLoad){
            if (!isLatestVersion) FMLInterModComms.sendRuntimeMessage(ChinaCraft.MODID,"VersionChecker","addUpdate", new CCUpdate().toJson());
        }
        if (isLatestVersion) {
            System.out.println("[ChinaCraft]You are running latest version = " + isLatestVersion);
        } else {

            System.out.println("[ChinaCraft]Found New version");
        }
    }

    public boolean isLatestVersion() {
        return isLatestVersion;
    }

    public int getLatestVersion() {
        return latestVersion;
    }

    public String getNewVersionInfo() {
        return newVersionInfo;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public boolean isCheckable() {
        return isCheckable;
    }
}
