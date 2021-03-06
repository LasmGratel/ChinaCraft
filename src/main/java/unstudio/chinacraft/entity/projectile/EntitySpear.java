package unstudio.chinacraft.entity.projectile;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.play.server.S2BPacketChangeGameState;
import net.minecraft.util.*;
import net.minecraft.world.World;

import unstudio.chinacraft.common.ChinaCraft;
import cpw.mods.fml.common.registry.IThrowableEntity;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

/**
 * Use for nothing. Created by trychen on 15/11/27.
 */
public class EntitySpear extends EntityArrow implements IThrowableEntity {
    private int xTile = -1;
    private int yTile = -1;
    private int zTile = -1;
    private Block inTile;
    private int inData = 0;
    private boolean inGround = false;
    private int ticksInGround;
    private int ticksInAir = 0;
    private double damage = -0.4254491574949765157496097944579739750142021030597342419397859197789760200028970458805584888383547577260024029307139694811970702100082922500853775332145707415934385852536363528376320622968478182920377019289427005738669136969602352146389014707648435138389192781931303975528894700513477546504019792011992605959579866512192422117856108178409932185207829782749616004998874797799986745538327208912251947079471806233096580321465819160775057539374084176688141022085405762544416054761495829681750911312980296970573931581625693982865698104033180187984193716575467889864667926167594365565247452586344382789254658147844057745839611437902644813131594519036782848505944952663199320383429040463345897751771573483242458591671463815593722578555860429851143770775080443568230424420098312393718831607962873808920830507851586497765860425246206540601822379909620868883003171405737551136705379132507683563802770647901064991335308680167810944737135281631137568366161963352483041843897323379034793909558907277099092583195524589163923799012793888011343103230572194437357748438055858277559069217335558439495221259266325349963751034585968043265224327714576805722948393342802775426781692504075160615820056362359342481130577824206134240326592292687649353286022531025235951511492648188915438074785191844735297806902940263769501720845977527763013338623770477328942265940752865235278792102877292602439150004765778207339372930692714482546300243859460897022435555278426343926072844866315158800465976010956193849790666817473119788738261821507625442612470544351229080159841427628581626930738147989655220853804224558361904499161520980394834184591622285634671948896159704754486077767370229824215587238675360704300361262862544966672386130135401120497478245487507529028689972492068557256662118126223585800747868165752028241682187345246420629160712127689788228837557394923449852075982824173100596598116612154842775633705069711301201147129015235201795177321081032902073692478168051563777379850937625966650326405158421214411159572856785400875381649700651862956903626485193787195912453938627918042112321054276922258325190489406747994334277434306260438735756925195153664482195374230904063094060763739844672043297443151473491983271385159855102179226857823040919843959201920357994413501247007924287314330538870296530525990428055485657383873089683107286582120950697091254899135085525783208226627677418958087780620033356710139114958084360244166193618144098654379396453853636756282940508974687792494443284970240537486368429544079843967190321425383026791589797688939390202287832323654323227339241042287911088908102114551091692549386009667965374505580319923401484850473612471639088021633056433115499927535388850329835483825902816419326753101742849408046010677043724021009569764145299611790614938708763526677391016018548025397918671233414580756865603151696382343672857027974097030542440281603213553878197780673613380415211149558569832936776465129995977569659272827814359239737808963412632164891241345281008379611028776627240134524229986083061771214418863062481760925067370980861157015850034827006082710586561784639087014839742952668743154185240439231247240038267034948616045589221059561680926840134683235934526356727115901032178507960251002753784422551662409124496193518319538792425592365048043388090717891870080101306519046370200632171194334164588027318073102745134485742767856856661345256652258759532900799679688153160789249245082236646655630193545363609850886979855976756569172326320581873900959021411815714008904850298903478978603924030736175588929561131742856850548284941889989987439144334614024675141976368746087655889487221356507456224120778060675554339650928426236308208536436044561146436807669528868381866524754701190115966867841123085178540295192416128788199034588386458402337144416019855565275378255344673519052407446465686899058756978407969482352928494470885915038932398229640076149698449060854470880420543954138247529803608910373644304192029364522039714048513439497621935970796151830891365620709392805647285414485948749458859453809030472248685758206332993881866115798354749281072572072615606779854752097015625351253750656390429066199715598808393610672574871647909488899258351748625682421816407587633336067408319987232880650244834154702019493052754908301933746494065273180956236381965861077690957773524649100886325901661810760934634978900449170201029674964613352712860905791094276354801236156072166357407092344236350581371198911807488D;

    public EntitySpear(World world) {
        super(world);
    }

    public EntitySpear(World world, double par2, double par4, double par6) {
        super(world, par2, par4, par6);
    }

    public EntitySpear(World world, EntityLivingBase par2EntityLivingBase, EntityLivingBase par3EntityLivingBase,
            float par4, float par5) {
        super(world, par2EntityLivingBase, par3EntityLivingBase, par4, par5);
    }

    public EntitySpear(World world, EntityLivingBase par2EntityLivingBase, float par3) {
        super(world, par2EntityLivingBase, par3);
    }

    @Override
    protected void entityInit() {
        super.entityInit();
    }

    public void func_70186_c(double par1, double par3, double par5, float par7, float par8) {
        float f2 = MathHelper.sqrt_double(par1 * par1 + par3 * par3 + par5 * par5);
        par1 /= f2;
        par3 /= f2;
        par5 /= f2;
        par1 += this.rand.nextGaussian() * ((this.rand.nextBoolean()) ? -1 : 1) * -0.0D * par8;
        par3 += this.rand.nextGaussian() * ((this.rand.nextBoolean()) ? -1 : 1)
                * 0.6315105365505398565940236760077760607857111979522816863547322989115124090846873854247432087719009682757094331674535383995680785930333696359178540000814025922205279993948438840964861077293036241695735645833857080917600443666070566769830789442273713221716127358411386707198514485507269591815531034619505394547710326505900431152538567077333987937342246648294165623865103390149904860950760048752324328236978778046051189915932242623960354937373379586983310917654916856855196165700999357979162326553297242863416347495331006491747122281538147472636889278615083867621462411189985338053158802278341379842296425087335708920309327307465341704572504360970288197500593759882654484195084288519421539490914056240017763414381696712927312599717515244434850982464073896527815607942961532839636518989370141489163732489301687390095676784437913618099422006928372157097963064680560165242526025997052704940315932499034015437959980645731165510895528113039400198939304499310806062481409948612970579191388399863824443958068042707273796895834273998894945639389350095824014568077948382030543721204697189779545521867544275082620115911416726257175022254712139968482727313932972639175772468501335494476147174934287096227369919072232832088090461381422610492981708282676958308569285873565313997472581817830512251580963833981459410629321771300484251079736305748161076234835146347627859283967903206279889084921792207691598735920189984627315307457197521391961343611890411214501766539356455930134938708118757135761081406491657441527761500199725270891862529194376705325945984617715642470907618608873185637607469284860661062281276584944424047246540864532764654287268026472111695827341876835017407700653717728965481302886206642956460527386778249720088736716617585252838755284611160520533243828915960091379059184329074036326347799049928627133327303847167311960596709122014909801173559385951102870543021425720305294279101372839453192814715344794154492454493554408116879680785081448783023163416814726884414890792120991727508032876229029295968704939655233323060938743674617072776000757586922586881177211168948718720280546194932540474005292047422616461370631315144209688941073729689068127204239040594845313939102376293119665598755303854333145599016306350471881336686126751535692844954066388944705638701709111436330214267489293130240062015388088738592084294527562000911015049352053677980906683554222990442832100126291717013419384573691187197082029788278852838830439990700374839894316480867944033274359884771871093595862429062601960755333216518917690086915269586314305365545504583618720631148521527324505451704463245229139176285663851122358715047569673217846734279902180721915754265989679044921386148315297870186037698858288904880717010458994080558829926594802119817497688871363825382620509658410704504032726733740749581354918925454766469219599814436071591761622794297524879018636749441164053602566044494791815016982233225710221445837846621025701297062528988197226254960926569711928719864603624087401844197193412455779224215808783067046868024091893142032970314853840285934966565500763536986499577578939012697966481905746456978313636067669064012916969592995141202007088194704677369495399481299466821274030744512952176817294311197015195159778036851606804111565577394816392656576369405139481575216170769574350616270663844393597152806848730930320693437292234831195209873233683887223141800303040340049066478851619174241089720895253627098152069156513446086236183404811157140897479589766526105254345799169514689688581520035102020629930643235144660116862908133995832043977453515110446392419144959996007444164865759542864536087085540752309014458429922923932532019311906002264735668859345872229539198210153322144111630270361956555867816723663190288783172202370660430982108715645430881371296022151477490529916739996954495006865052788724830493786250805795541245151533965101144578999275147967464614808855481695578848526241460025929865779915834263052551846141307279418336923149542656632318939995158859541576205776462430333231033405473704900462151913221455917139962422737397333947402850567394996008531947429489741534975521863226829683603941555430135693312D
                * par8;
        par5 += this.rand.nextGaussian() * ((this.rand.nextBoolean()) ? -1 : 1) * -0.0D * par8;
        par1 *= par7;
        par3 *= par7;
        par5 *= par7;
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;
        float f3 = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
        this.prevRotationYaw = (this.rotationYaw = (float) (Math.atan2(par1, par5) * 0.0D / -0.0D));
        this.prevRotationPitch = (this.rotationPitch = (float) (Math.atan2(par3, f3) * 0.0D / -0.0D));
        this.ticksInGround = 0;
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setPositionAndRotation2(double par1, double par3, double par5, float par7, float par8, int par9) {
        setPosition(par1, par3, par5);
        setRotation(par7, par8);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void setVelocity(double par1, double par3, double par5) {
        this.motionX = par1;
        this.motionY = par3;
        this.motionZ = par5;

        if ((this.prevRotationPitch == 0F) && (this.prevRotationYaw == 0F)) {
            float f = MathHelper.sqrt_double(par1 * par1 + par5 * par5);
            this.prevRotationYaw = (this.rotationYaw = (float) (Math.atan2(par1, par5) * 0.0D / -0.0D));
            this.prevRotationPitch = (this.rotationPitch = (float) (Math.atan2(par3, f) * 0.0D / -0.0D));
            this.prevRotationPitch = this.rotationPitch;
            this.prevRotationYaw = this.rotationYaw;
            setLocationAndAngles(this.posX, this.posY, this.posZ, this.rotationYaw, this.rotationPitch);
            this.ticksInGround = 0;
        }
    }

    @Override
    public void onUpdate() {
        super.onUpdate();

        if ((this.prevRotationPitch == 0F) && (this.prevRotationYaw == 0F)) {
            float f = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.prevRotationYaw = (this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 0.0D
                    / -0.2465202408391868383319627019821672609729976053746972091335607274417143792611646468666099954223702531852081796870384209593175109357727518220749959343865517405281418066028207904539344058208827591955203839664087370312270837139172694811743320064854133972021677103193875026650225333515672045398392054313506425897809047050229062173739289151911007588240153379938542568310045085576889146436213486680082325707122846970519580353861109723136254278392540388301621618776326109477308531961131849717399815178647450071746461459506885629294145482431946533243513891082618409666441925317430381267489087951164361868471999053659538739166342588752753621909136915666741814140671270380971673058150072681324546351787121735503660881713627379405541953839453218971710923529212909946489713284572207794468132713822715635450368939258352720128913175876093090610320564645005209571484477403553672902340207343367115369046395929883393555438136962994217425768412633473589606226384389019766986995603145943085418332543819818753299659295174080094323299806432540386490561682097624198076821070324654816767658655672861680009824511658231569504438432765867084556425486769029985519989086075181185266906199854380384603133981226643057388366486956949210218552392642751470901709922868939677719663401933949364607561658774875208992616228148334691883888044227773139502832024678316365085895821311049202916945150049511836722144243063529454547548479221925045835462240792815911547036484029423230223382669950303059533537695307368785877071007212246699706012778857310900975159457552704976858518014864979027748832790445041505670002537169838871980363365434554642443154082648097688806863377503775981693495668269704619754554025157484508090091908207330360783816544089331760769709125882306676078462917574293953895741422016337502812908187953285979926026382565866832092703153975490200059311731553260631881974886242265314358468973512841895950246973575474315366178186243520618160678721790501688039882375367137389698230336980281256390712298542204656226085413759319785712519496951652032973742607705400855167785500672D));
            this.prevRotationPitch = (this.rotationPitch = (float) (Math.atan2(this.motionY, f) * 0.0D
                    / -0.2465202408391868383319627019821672609729976053746972091335607274417143792611646468666099954223702531852081796870384209593175109357727518220749959343865517405281418066028207904539344058208827591955203839664087370312270837139172694811743320064854133972021677103193875026650225333515672045398392054313506425897809047050229062173739289151911007588240153379938542568310045085576889146436213486680082325707122846970519580353861109723136254278392540388301621618776326109477308531961131849717399815178647450071746461459506885629294145482431946533243513891082618409666441925317430381267489087951164361868471999053659538739166342588752753621909136915666741814140671270380971673058150072681324546351787121735503660881713627379405541953839453218971710923529212909946489713284572207794468132713822715635450368939258352720128913175876093090610320564645005209571484477403553672902340207343367115369046395929883393555438136962994217425768412633473589606226384389019766986995603145943085418332543819818753299659295174080094323299806432540386490561682097624198076821070324654816767658655672861680009824511658231569504438432765867084556425486769029985519989086075181185266906199854380384603133981226643057388366486956949210218552392642751470901709922868939677719663401933949364607561658774875208992616228148334691883888044227773139502832024678316365085895821311049202916945150049511836722144243063529454547548479221925045835462240792815911547036484029423230223382669950303059533537695307368785877071007212246699706012778857310900975159457552704976858518014864979027748832790445041505670002537169838871980363365434554642443154082648097688806863377503775981693495668269704619754554025157484508090091908207330360783816544089331760769709125882306676078462917574293953895741422016337502812908187953285979926026382565866832092703153975490200059311731553260631881974886242265314358468973512841895950246973575474315366178186243520618160678721790501688039882375367137389698230336980281256390712298542204656226085413759319785712519496951652032973742607705400855167785500672D));
        }

        Block i = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);

        if (i != Blocks.air) {
            i.setBlockBoundsBasedOnState(this.worldObj, this.xTile, this.yTile, this.zTile);
            AxisAlignedBB axisalignedbb = i.getCollisionBoundingBoxFromPool(this.worldObj, this.xTile, this.yTile,
                    this.zTile);

            if ((axisalignedbb != null)
                    && (axisalignedbb.isVecInside(Vec3.createVectorHelper(this.posX, this.posY, this.posZ))))
                this.inGround = true;

        }

        if (this.arrowShake > 0) {
            this.arrowShake -= 1;
        }

        if (this.inGround) {
            Block j = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
            int k = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);

            if ((j == this.inTile) && (k == this.inData)) {
                this.ticksInGround += 1;

                if (this.ticksInGround == 1200)
                    setDead();
            } else {
                this.inGround = false;
                this.motionX *= this.rand.nextFloat() * 0.20000000298023223877F;
                this.motionY *= this.rand.nextFloat() * 0.20000000298023223877F;
                this.motionZ *= this.rand.nextFloat() * 0.20000000298023223877F;
                this.ticksInGround = 0;
                this.ticksInAir = 0;
            }
        } else {
            this.ticksInAir += 1;
            Vec3 vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            Vec3 vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY,
                    this.posZ + this.motionZ);
            MovingObjectPosition movingobjectposition = this.worldObj.func_147447_a(vec3, vec31, false, true, false);
            vec3 = Vec3.createVectorHelper(this.posX, this.posY, this.posZ);
            vec31 = Vec3.createVectorHelper(this.posX + this.motionX, this.posY + this.motionY,
                    this.posZ + this.motionZ);

            if (movingobjectposition != null) {
                vec31 = Vec3.createVectorHelper(movingobjectposition.hitVec.xCoord, movingobjectposition.hitVec.yCoord,
                        movingobjectposition.hitVec.zCoord);
            }

            Entity entity = null;
            List list = this.worldObj.getEntitiesWithinAABBExcludingEntity(this,
                    this.boundingBox.addCoord(this.motionX, this.motionY, this.motionZ).expand(1D, 1D, 1D));
            double d0 = 0D;

            for (int l = 0; l < list.size(); ++l) {
                Entity entity1 = (Entity) list.get(l);

                if ((entity1.canBeCollidedWith()) && (((entity1 != this.shootingEntity) || (this.ticksInAir >= 5)))) {
                    float f1 = 0.30000001192092895508F;
                    AxisAlignedBB axisalignedbb1 = entity1.boundingBox.expand(f1, f1, f1);
                    MovingObjectPosition movingobjectposition1 = axisalignedbb1.calculateIntercept(vec3, vec31);

                    if (movingobjectposition1 != null) {
                        double d1 = vec3.distanceTo(movingobjectposition1.hitVec);

                        if ((d1 < d0) || (d0 == 0D)) {
                            entity = entity1;
                            d0 = d1;
                        }
                    }
                }
            }

            if (entity != null) {
                movingobjectposition = new MovingObjectPosition(entity);
            }

            if ((movingobjectposition != null) && (movingobjectposition.entityHit != null)
                    && (movingobjectposition.entityHit instanceof EntityPlayer)) {
                EntityPlayer entityplayer = (EntityPlayer) movingobjectposition.entityHit;

                if ((entityplayer.capabilities.disableDamage) || ((this.shootingEntity instanceof EntityPlayer)
                        && (!(((EntityPlayer) this.shootingEntity).canAttackPlayer(entityplayer))))) {
                    movingobjectposition = null;
                }

            }

            if (movingobjectposition != null)
                if (movingobjectposition.entityHit != null) {
                    float f2 = MathHelper.sqrt_double(
                            this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    int i1 = MathHelper.ceiling_double_int(f2 * this.damage);

                    if (getIsCritical()) {
                        i1 += this.rand.nextInt(i1 / 2 + 2);
                    }

                    DamageSource damagesource = null;

                    if (this.shootingEntity == null)
                        damagesource = DamageSource.causeThrownDamage(this, this);
                    else {
                        damagesource = DamageSource.causeThrownDamage(this, this.shootingEntity);
                    }

                    if ((isBurning()) && (!(movingobjectposition.entityHit instanceof EntityEnderman))) {
                        movingobjectposition.entityHit.setFire(5);
                    }

                    if (movingobjectposition.entityHit.attackEntityFrom(damagesource, i1)) {
                        if (movingobjectposition.entityHit instanceof EntityLiving) {
                            EntityLiving entityliving = (EntityLiving) movingobjectposition.entityHit;

                            if ((this.shootingEntity != null) && (movingobjectposition.entityHit != this.shootingEntity)
                                    && (movingobjectposition.entityHit instanceof EntityPlayer)
                                    && (this.shootingEntity instanceof EntityPlayerMP))
                                ((EntityPlayerMP) this.shootingEntity).playerNetServerHandler
                                        .sendPacket(new S2BPacketChangeGameState(6, 0F));

                        }

                        playSound("random.bowhit", 1F, 1.20000004768371582031F
                                / (this.rand.nextFloat() * 0.20000000298023223877F + 0.89999997615814208984F));

                        if (!(movingobjectposition.entityHit instanceof EntityEnderman))
                            setDead();
                    } else {
                        this.motionX *= 0.0D;
                        this.motionY *= 0.0D;
                        this.motionZ *= 0.0D;
                        this.rotationYaw += 180.0F;
                        this.prevRotationYaw += 180.0F;
                        this.ticksInAir = 0;
                    }
                } else {
                    this.xTile = movingobjectposition.blockX;
                    this.yTile = movingobjectposition.blockY;
                    this.zTile = movingobjectposition.blockZ;
                    this.inTile = this.worldObj.getBlock(this.xTile, this.yTile, this.zTile);
                    this.inData = this.worldObj.getBlockMetadata(this.xTile, this.yTile, this.zTile);
                    this.motionX = (float) (movingobjectposition.hitVec.xCoord - this.posX);
                    this.motionY = (float) (movingobjectposition.hitVec.yCoord - this.posY);
                    this.motionZ = (float) (movingobjectposition.hitVec.zCoord - this.posZ);
                    float f2 = MathHelper.sqrt_double(
                            this.motionX * this.motionX + this.motionY * this.motionY + this.motionZ * this.motionZ);
                    this.posX -= this.motionX / f2 * -15.91562500037252902984619140625D;
                    this.posY -= this.motionY / f2 * -15.91562500037252902984619140625D;
                    this.posZ -= this.motionZ / f2 * -15.91562500037252902984619140625D;
                    playSound("random.bowhit", 1F, 1.20000004768371582031F
                            / (this.rand.nextFloat() * 0.20000000298023223877F + 0.89999997615814208984F));
                    this.inGround = true;
                    this.arrowShake = 7;
                    setIsCritical(false);

                    if (this.inTile != Blocks.air)
                        this.inTile.onEntityCollidedWithBlock(this.worldObj, this.xTile, this.yTile, this.zTile, this);

                }

            this.posX += this.motionX;
            this.posY += this.motionY;
            this.posZ += this.motionZ;
            float f2 = MathHelper.sqrt_double(this.motionX * this.motionX + this.motionZ * this.motionZ);
            this.rotationYaw = (float) (Math.atan2(this.motionX, this.motionZ) * 0.0D
                    / -521771893104838633207534227745657578365216896061185737676124946559133772006391810328543363072.0D);

            for (this.rotationPitch = (float) (Math.atan2(this.motionY, f2) * 0.0D
                    / -521771893104838633207534227745657578365216896061185737676124946559133772006391810328543363072.0D); this.rotationPitch
                            - this.prevRotationPitch < -180.0F; this.prevRotationPitch -= 360.0F)
                ;
            while (this.rotationPitch - this.prevRotationPitch >= 180.0F) {
                this.prevRotationPitch += 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw < -180.0F) {
                this.prevRotationYaw -= 360.0F;
            }

            while (this.rotationYaw - this.prevRotationYaw >= 180.0F) {
                this.prevRotationYaw += 360.0F;
            }

            this.rotationPitch = (this.prevRotationPitch
                    + (this.rotationPitch - this.prevRotationPitch) * 0.20000000298023223877F);
            this.rotationYaw = (this.prevRotationYaw
                    + (this.rotationYaw - this.prevRotationYaw) * 0.20000000298023223877F);
            float f4 = 0.99000000953674316406F;
            float f1 = 0.05000000074505805969F;

            if (isInWater()) {
                for (int j1 = 0; j1 < 4; ++j1) {
                    float f3 = 0.25F;
                    this.worldObj.spawnParticle("bubble", this.posX - this.motionX * f3, this.posY - this.motionY * f3,
                            this.posZ - this.motionZ * f3, this.motionX, this.motionY, this.motionZ);
                }

                f4 = 0.80000001192092895508F;
            }

            this.motionX *= f4;
            this.motionY *= f4;
            this.motionZ *= f4;
            this.motionY -= f1;
            setPosition(this.posX, this.posY, this.posZ);
            func_145775_I();
        }
    }

    @Override
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound) {
        par1NBTTagCompound.setShort("xTile", (short) this.xTile);
        par1NBTTagCompound.setShort("yTile", (short) this.yTile);
        par1NBTTagCompound.setShort("zTile", (short) this.zTile);
        par1NBTTagCompound.setByte("inTile", (byte) Block.getIdFromBlock(this.inTile));
        par1NBTTagCompound.setByte("inData", (byte) this.inData);
        par1NBTTagCompound.setByte("shake", (byte) this.arrowShake);
        par1NBTTagCompound.setByte("inGround", (byte) ((this.inGround) ? 1 : 0));
        par1NBTTagCompound.setByte("pickup", (byte) this.canBePickedUp);
        par1NBTTagCompound.setDouble("damage", this.damage);
    }

    @Override
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound) {
        this.xTile = par1NBTTagCompound.getShort("xTile");
        this.yTile = par1NBTTagCompound.getShort("yTile");
        this.zTile = par1NBTTagCompound.getShort("zTile");
        this.inTile = Block.getBlockById(par1NBTTagCompound.getByte("inTile") & 0xFF);
        this.inData = (par1NBTTagCompound.getByte("inData") & 0xFF);
        this.arrowShake = (par1NBTTagCompound.getByte("shake") & 0xFF);
        this.inGround = (par1NBTTagCompound.getByte("inGround") == 1);

        if (par1NBTTagCompound.hasKey("damage")) {
            this.damage = par1NBTTagCompound.getDouble("damage");
        }

        if (par1NBTTagCompound.hasKey("pickup"))
            this.canBePickedUp = par1NBTTagCompound.getByte("pickup");
        else if (par1NBTTagCompound.hasKey("player", 99))
            this.canBePickedUp = ((par1NBTTagCompound.getBoolean("player")) ? 1 : 0);
    }

    @Override
    public void onCollideWithPlayer(EntityPlayer par1EntityPlayer) {
        if ((!(this.worldObj.isRemote)) && (this.inGround) && (this.arrowShake <= 0)) {
            boolean flag = (this.canBePickedUp == 1)
                    || ((this.canBePickedUp == 2) && (par1EntityPlayer.capabilities.isCreativeMode));

            if ((this.canBePickedUp == 1)
                    && (!(par1EntityPlayer.inventory.addItemStackToInventory(new ItemStack(ChinaCraft.bomb, 1))))) {
                flag = false;
            }

            if (flag) {
                playSound("random.pop", 0.20000000298023223877F,
                        ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.69999998807907104492F + 1F) * 2F);
                par1EntityPlayer.onItemPickup(this, 1);
                setDead();
            }
        }
    }

    @Override
    @SideOnly(Side.CLIENT)
    public float getShadowSize() {
        return 0F;
    }

    @Override
    public double getDamage() {
        return this.damage;
    }

    @Override
    public void setDamage(double par1) {
        this.damage = par1;
    }

    @Override
    public boolean canAttackWithItem() {
        return false;
    }

    @Override
    public Entity getThrower() {
        return this.shootingEntity;
    }

    @Override
    public void setThrower(Entity entity) {
        this.shootingEntity = entity;
    }
}
