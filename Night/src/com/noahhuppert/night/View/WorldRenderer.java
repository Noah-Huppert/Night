package com.noahhuppert.night.View;

import java.util.Iterator;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL10;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Pixmap.Format;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes.Usage;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.AtlasRegion;
import com.badlogic.gdx.graphics.g2d.TextureAtlas.TextureAtlasData;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.environment.DirectionalLight;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Quaternion;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.physics.bullet.collision.btBroadphaseInterface;
import com.badlogic.gdx.physics.bullet.collision.btCollisionDispatcher;
import com.badlogic.gdx.physics.bullet.collision.btCollisionShape;
import com.badlogic.gdx.physics.bullet.collision.btDbvtBroadphase;
import com.badlogic.gdx.physics.bullet.collision.btDefaultCollisionConfiguration;
import com.badlogic.gdx.physics.bullet.collision.btSphereShape;
import com.badlogic.gdx.physics.bullet.collision.btStaticPlaneShape;
import com.badlogic.gdx.physics.bullet.dynamics.btDiscreteDynamicsWorld;
import com.badlogic.gdx.physics.bullet.dynamics.btSequentialImpulseConstraintSolver;
import com.badlogic.gdx.physics.bullet.extras.btBulletWorldImporter;
import com.badlogic.gdx.physics.bullet.linearmath.btDefaultMotionState;
import com.badlogic.gdx.physics.bullet.linearmath.btTransform;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Array;
import com.esotericsoftware.spine.Animation;
import com.esotericsoftware.spine.Event;
import com.esotericsoftware.spine.Skeleton;
import com.esotericsoftware.spine.SkeletonData;
import com.esotericsoftware.spine.SkeletonJson;
import com.esotericsoftware.spine.SkeletonRenderer;
import com.esotericsoftware.spine.SkeletonRendererDebug;
import com.noahhuppert.night.Night;
import com.noahhuppert.night.Model.Entity;
import com.noahhuppert.night.Model.Player;

public class WorldRenderer {
	World world;
	//Environment environment;
	//PerspectiveCamera cam;
	OrthographicCamera cam;
	SpriteBatch batch;
	
	//For Spine
	/*SkeletonRenderer renderer;
    SkeletonRendererDebug debugRenderer;
	
    SkeletonData skeletonData;
    Skeleton skeleton;
    Animation animation;
    Array<Event> events = new Array();
    
    float time;*/
    
	
	Iterator<Entity> entityIter;
	Array<Entity> entities = new Array<Entity>();
	Entity eIterNext;
	
	Player player;
	/*AssetManager assets;
	ModelBatch modelBatch;
	Model mainCharecterModel;
	ModelInstance mainCharecter;
	public Array<ModelInstance> instances = new Array<ModelInstance>();

	Model model;
	ModelBuilder modelBuilder;
	ModelInstance floor;*/

	// Bullet
	/*btBroadphaseInterface broadphase = new btDbvtBroadphase();

	btDefaultCollisionConfiguration collisionConfiguration = new btDefaultCollisionConfiguration();
	btCollisionDispatcher dispatcher = new btCollisionDispatcher(
			collisionConfiguration);

	btSequentialImpulseConstraintSolver solver = new btSequentialImpulseConstraintSolver();

	btDiscreteDynamicsWorld dynamicsWorld = new btDiscreteDynamicsWorld(
			dispatcher, broadphase, solver, collisionConfiguration);*/

	String assetPaths[] = new String[1];

	float width;
	float height;
	boolean loading;

	public WorldRenderer(World world) {
		assetPaths[0] = "data/mainCharecter/mainCharecter2.g3db";
		this.world = world;
		
		//renderer = new SkeletonRenderer();//SPINE
        //debugRenderer = new SkeletonRendererDebug();

        final String name = "spineboy";

		// Bullet
		/*dynamicsWorld.setGravity(new Vector3(0, -10, 0));// Set up gravity
		btCollisionShape groundShape = new btStaticPlaneShape(new Vector3(500, 1, 500), 1);//Ground
		btCollisionShape fallShape = new btSphereShape(1);//Sphere
		
		btDefaultMotionState groundMotionState = new btDefaultMotionState(btTransform(new Quaternion(0, 0, 0, 1), new Vector3(0, -1, 0)));

		environment = new Environment();
		environment.set(new ColorAttribute(ColorAttribute.AmbientLight, 0.4f,
				0.4f, 0.4f, 1f));
		environment.add(new DirectionalLight().set(0.8f, 0.8f, 0.8f, -1f,
				-0.8f, -0.2f));

		cam = new PerspectiveCamera(67, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		cam.position.set(50f, 5f, 0f);
		cam.lookAt(0, 5f, 0);
		cam.near = 0.1f;
		cam.far = 300f;
		cam.update();*/
		
		width = (Gdx.graphics.getWidth() / 10);
		height = (Gdx.graphics.getHeight() / 10);
		
		cam = new OrthographicCamera();
		cam.setToOrtho(false, width, height);
		cam.update();
		
		batch = new SpriteBatch();
		batch.setProjectionMatrix(cam.combined);
		
		entities = world.getEntities();
		
		player = world.getPlayer();
		
		/*FileHandle atlasFile = Gdx.files.internal(name + ".atlas");//SPINE
		
		Pixmap pixmap = new Pixmap(32, 32, Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        final AtlasRegion fake = new AtlasRegion(new Texture(pixmap), 0, 0, 32, 32);
        pixmap.dispose();*/
		
       /* TextureAtlasData data = !atlasFile.exists() ? null : new TextureAtlasData(atlasFile, atlasFile.parent(), false);
        
		TextureAtlas atlas = new TextureAtlas(data) {
			public AtlasRegion findRegion (String name) {
                AtlasRegion region = super.findRegion(name);
                return region != null ? region : fake;
			}
		};*/
        
       /* TextureAtlas atlas = new TextureAtlas();
		
		SkeletonJson json = new SkeletonJson(atlas);
		
		skeletonData = json.readSkeletonData(Gdx.files.internal("data/spineboy/spineboy.json"));
		
		animation = skeletonData.findAnimation("jump");

        skeleton = new Skeleton(skeletonData);
        if (name.equals("goblins")) skeleton.setSkin("goblin");
        skeleton.setToSetupPose();
        skeleton = new Skeleton(skeleton);
        skeleton.updateWorldTransform();*///END BULLET

		/*Night.advLog("Models", "Loading");
		modelBatch = new ModelBatch();
		assets = new AssetManager();
		assets.load(assetPaths[0], Model.class);

		modelBuilder = new ModelBuilder();

		loading = true;*/
	}

	public void render() {

		/*if (loading == true && assets.update() == true) {
			doneLoading();
		}*/
		Gdx.gl.glClearColor(1, 1, 1, 1);
		Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(),
				Gdx.graphics.getHeight());
		Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT | GL10.GL_DEPTH_BUFFER_BIT);

		/*if (loading == false) {
			cam.lookAt(0, 0, 0);
			cam.update();

			modelBatch.begin(cam);
			modelBatch.render(instances, environment);
			modelBatch.end();
		}*/

		world.setRenderer(this);
		
		entityIter = entities.iterator();
		
		cam.position.set(5, 10, 0);
		cam.update();//Updates camera
		batch.setProjectionMatrix(cam.combined);
		
		/*float lastTime = time;//SPINE
        time += Gdx.graphics.getDeltaTime();

        float x = skeleton.getX() + 160 * Gdx.graphics.getDeltaTime() * (skeleton.getFlipX() ? -1 : 1);
        if (x > Gdx.graphics.getWidth()) skeleton.setFlipX(true);
        if (x < 0) skeleton.setFlipX(false);
        skeleton.setX(x);

        Gdx.gl.glClear(GL10.GL_COLOR_BUFFER_BIT);

        events.clear();
        animation.apply(skeleton, lastTime, time, true, events);
        if (events.size > 0) System.out.println(events);

        skeleton.updateWorldTransform();
        skeleton.update(Gdx.graphics.getDeltaTime());*/
		
		batch.begin();//Rendering
			while(entityIter.hasNext()){//Regular entity rendering
				eIterNext = entityIter.next();
				batch.draw(new Texture(eIterNext.getTexturePath()), eIterNext.getPosition().x, eIterNext.getPosition().y, eIterNext.getWidth(), eIterNext.getHeight());
			}
			
			//Player rendering
			batch.draw(new Texture(player.getTexturePath()), player.getPosition().x, player.getPosition().y, player.getWidth(), player.getHeight());
			//renderer.draw(batch, skeleton);//SPINE
		batch.end();
		
		//debugRenderer.draw(skeleton);//SPINE
	}

	/*private void doneLoading() {
		mainCharecter = new ModelInstance(
				assets.get(assetPaths[0], Model.class));
		mainCharecter.transform.setToRotation(Vector3.Y, 180).trn(0, 0, 0f);
		instances.add(mainCharecter);

		model = modelBuilder.createBox(500f, 1f, 500f,
				new Material(ColorAttribute.createDiffuse(Color.DARK_GRAY)),
				Usage.Position | Usage.Normal);
		floor = new ModelInstance(model);
		floor.transform.translate(new Vector3(0, -22, 0));
		instances.add(floor);

		loading = false;
		Night.advLog("Models", "Loading Complete");
	}*/

	/*public PerspectiveCamera getCamera() {
		return cam;
	}*/
	
	public OrthographicCamera getCamera() {
		return cam;
	}

	public void update() {

	}

	public void dispose() {
		// Bullet
		/*broadphase.dispose();
		collisionConfiguration.dispose();
		dispatcher.dispose();
		solver.dispose();
		dynamicsWorld.dispose();*/

		/*modelBatch.dispose();
		mainCharecterModel.dispose();
		assets.dispose();*/
		batch.dispose();
	}
}
