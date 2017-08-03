package com.techlad.instabio;

/**
 * Created by Kshitij on 8/2/2017.
 */

        import com.squareup.picasso.Picasso;

        import android.content.Context;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.BaseAdapter;
        import android.widget.GridView;
        import android.widget.ImageView;

public class ImageAdapter extends BaseAdapter {
    private Context mContext;
    int imageTotal = 77;
    public static String[] mThumbIds = {
            "https://image.ibb.co/jZpH4k/914394_1450274388557378_558919284_n.jpg",
            "https://image.ibb.co/hNtc4k/923823_732108936844731_1093851126_n.jpg",
            "https://image.ibb.co/c074jk/925305_1426362537645994_1797270702_n.jpg",
            "https://image.ibb.co/eSVeH5/927359_365893210246719_1564962028_n.jpg",
            "https://image.ibb.co/b01aqQ/928011_425922797550660_1704160066_n.jpg",
            "https://image.ibb.co/ih1x4k/928929_1544067402548009_1471892480_n.jpg",
            "https://image.ibb.co/nMLDc5/928951_1401347183508310_1207146310_n.jpg",
            "https://image.ibb.co/dOkPjk/1171650_206591189684748_1489330057_n.jpg",
            "https://image.ibb.co/dHa1VQ/1736878_872547372758351_1341043459_n.jpg",
            "https://image.ibb.co/efVDc5/1742524_710999755652045_995684138_n.jpg",
            "https://image.ibb.co/jTVqPk/10261190_1721453721423388_1617602806_n.jpg",
            "https://image.ibb.co/dBGaqQ/10387797_410660649119054_156929178_n.jpg",
            "https://image.ibb.co/ixWVPk/10520124_1547694465488270_1396510793_n.jpg",
            "https://image.ibb.co/mKvqPk/10540498_1525654984337788_1340143033_n.jpg",
            "https://image.ibb.co/kn6aqQ/10570078_925668554151848_129701325_n.jpg",
            "https://image.ibb.co/etwaqQ/10576181_1463790793880125_1354041096_n.jpg",
            "https://image.ibb.co/euhtc5/10598372_1459379327669623_918624756_n.jpg",
            "https://image.ibb.co/khgVPk/10610978_1471640496450908_1035242318_n.jpg",
            "https://image.ibb.co/jgVPjk/10617008_770591662991688_1412891960_n.jpg",
            "https://image.ibb.co/dfTMVQ/10624530_673062962772182_26179820_n.jpg",
            "https://image.ibb.co/gQ1aqQ/10632159_760713203988949_152374296_n.jpg",
            "https://image.ibb.co/ejWx4k/10643925_367872146694189_1315179051_n.jpg",
            "https://image.ibb.co/j3BKH5/10654881_526793110807894_1920754946_n.jpg",
            "https://image.ibb.co/cXz6x5/10666101_1545896105630312_1855032983_n.jpg",
            "https://image.ibb.co/jaVkqQ/10666217_566159643512804_602743566_n.jpg",
            "https://image.ibb.co/i8i5qQ/10683952_1509169932662841_1401585788_n.jpg",
            "https://image.ibb.co/kDi5qQ/10684049_706419499448105_2051371448_n.jpg",
            "https://image.ibb.co/n2H9H5/10691836_1487903498143323_327646496_n.jpg",
            "https://image.ibb.co/fbNWVQ/10693657_616929718416039_728033845_n.jpg",
            "https://image.ibb.co/kerfPk/10727237_350492401792709_88081420_n.jpg",
            "https://image.ibb.co/eA8S4k/10729453_1495308134087038_990572283_n.jpg",
            "https://image.ibb.co/kMHyAQ/10808973_1578944219001571_1837519619_n.jpg",
            "https://image.ibb.co/kbkUH5/10817876_1602879346606883_936959423_n.jpg",
            "https://image.ibb.co/cHZpH5/10864694_779605568743760_429864148_n.jpg",
            "https://image.ibb.co/e6Nbx5/10882019_1435535033388171_1855636031_n.jpg",
            "https://image.ibb.co/iBxWVQ/10903239_1593595354196732_1068795832_n.jpg",
            "https://image.ibb.co/dsaUH5/10914667_800567959998080_195487119_n.jpg",
            "https://image.ibb.co/jrEBVQ/10932457_1606805156206543_1904366910_n.jpg",
            "https://image.ibb.co/j0VkqQ/10958636_433741890111601_1308687252_n.jpg",
            "https://image.ibb.co/mx0UH5/10979577_744062909023020_1854944263_n.jpg",
            "https://image.ibb.co/djx9H5/10985997_797859443584967_298259221_n.jpg",
            "https://image.ibb.co/eRoGx5/11015578_787382584688579_1407085032_n.jpg",
            "https://image.ibb.co/ewU0Pk/11078892_861353433906555_212095668_n.jpg",
            "https://image.ibb.co/cm9Zjk/11137898_1376848915977062_2096652902_n.jpg",
            "https://image.ibb.co/fOzpH5/11249056_1466398007009628_1926243261_n.jpg",
            "https://image.ibb.co/eVWfPk/11259917_947282758643406_1997863464_n.jpg",
            "https://image.ibb.co/hDKBVQ/11266295_855381757849077_618833968_n.jpg",
            "https://image.ibb.co/cq13c5/11348084_1069289903081457_854052399_n.jpg",
            "https://image.ibb.co/dedic5/11357560_849052501798223_159528344_n.jpg",
            "https://image.ibb.co/bO5JAQ/11374291_457589994432935_996545124_n.jpg",
            "https://image.ibb.co/kq2yAQ/11377536_101673230176479_1368159447_n.jpg",
            "https://image.ibb.co/iAZOc5/11377774_839786202756527_1616023438_n.jpg",
            "https://image.ibb.co/jFXWVQ/11379199_962372270469064_423481433_n.jpg",
            "https://image.ibb.co/nnYujk/11383298_1620368784869930_1853371894_n.jpg",
            "https://image.ibb.co/f3Kjjk/11385170_1442455049389357_1902123235_n.jpg",
            "https://image.ibb.co/getzH5/12424392_171816333189390_1054164622_n.jpg",
            "https://image.ibb.co/cMM8AQ/12424787_1763622613870473_681152415_n.jpg",
            "https://image.ibb.co/ipNgVQ/12479502_433229343537613_1918832211_n.jpg",
            "https://image.ibb.co/kR0qPk/12530736_686325924841105_1369254879_n.jpg",
            "https://image.ibb.co/ks7Rx5/12552187_1672554899672223_1011021726_n.jpg",
            "https://image.ibb.co/iM4TAQ/12552211_1656939211237928_2029942590_n.jpg",
            "https://image.ibb.co/eUyYc5/12558655_615027325312980_1281647697_n.jpg",
            "https://image.ibb.co/m9f1VQ/12716826_133890970330275_1596554356_n.jpg",
            "https://image.ibb.co/dDWmx5/12717099_1063574990360070_1629183345_n.jpg",
            "https://image.ibb.co/dnHgVQ/12725092_1765883636973477_1771255808_n.jpg",
            "https://image.ibb.co/dk2Rx5/12728619_1673347496271786_2081612346_n.jpg",
            "https://image.ibb.co/hmntc5/19120365_811138229036080_5248809511589773312_n.jpg",
            "https://image.ibb.co/hK2FqQ/19955057_675189202681687_955429944740020224_n.jpg",
            "https://image.ibb.co/gfGKH5/19985471_115397132419981_3230854900346781696_n.jpg",
            "https://image.ibb.co/jvUH4k/20065234_1711296685838803_7451311415773626368_n.jpg",
            "https://image.ibb.co/epAeH5/20180808_1620961314641874_2143484200223768576_n.jpg",
            "https://image.ibb.co/b9k74k/20184499_1398964320195638_8439187901404676096_n.jpg",
            "https://image.ibb.co/g4Hbx5/20225696_191931711344682_1187856175887024128_n.jpg",
            "https://image.ibb.co/iS63c5/20347150_106648756675917_6850145539137208320_n.jpg",
            "https://image.ibb.co/b2t5qQ/20393493_143082389609606_747844296899559424_n.jpg",
            "https://image.ibb.co/g4awx5/20398428_1881715515412461_4292082984942567424_n.jpg",
            "https://image.ibb.co/fSK0Pk/20481862_107248869973184_2261578032584065024_n.jpg"
    };

    public ImageAdapter(Context c) {
        mContext = c;
    }

    public int getCount() {
        return imageTotal;
    }

    @Override
    public String getItem(int position) {
        return mThumbIds[position];
    }

    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;
        if (convertView == null) {
            imageView = new ImageView(mContext);
            imageView.setLayoutParams(new GridView.LayoutParams(480, 480));
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        } else {
            imageView = (ImageView) convertView;
        }
        String url = getItem(position);
        Picasso.with(mContext)
                .load(url)
                .placeholder(R.drawable.loader)
                .fit()
                .centerCrop().into(imageView);
        return imageView;
    }
}