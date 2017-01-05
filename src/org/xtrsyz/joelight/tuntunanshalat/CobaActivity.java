package org.xtrsyz.joelight.tuntunanshalat;



import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;


public class CobaActivity extends Activity {

	ImageView gambar;
	ImageView image_content;
	Bundle b;
	String nama;
	MediaPlayer mp;
	Handler mHandler = new Handler();
	Handler pusing = new Handler();
	private volatile Thread bingung = new Thread();
	
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gambar);
        
        b = getIntent().getExtras(); 
	    nama = b.getString("name");
	    
	    Button tombolBalik = (Button) findViewById(R.id.button1);
	    tombolBalik.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bingung.interrupt();
				//bingung = null;
				StopSound();
				finish();
			}
		});
	    
	    Button tombolInfo = (Button) findViewById(R.id.buttonInfo);
	    tombolInfo.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				bingung.interrupt();
				//bingung = null;
				StopSound();
		        Intent intent = new Intent( getBaseContext(), InfoActivity.class);  
	            Bundle b = new Bundle();
	            b.putString("name", nama.replace(" ", "") );
	            intent.putExtras(b);
	            startActivity(intent);  
			}
		});
	    
	    
	    if (nama.equalsIgnoreCase("takbir")) {
	    	gerakan_takbir();
	    } else if (nama.equalsIgnoreCase("rukuk")) {
	    	gerakan_rukuk();
	    } else if (nama.equalsIgnoreCase("ikhtidal")) {
	    	gerakan_ikhtidal();
	    } else if (nama.equalsIgnoreCase("sujud")) {
	    	gerakan_sujud();
	    } else if (nama.equalsIgnoreCase("duduk diantara dua sujud")) {
	    	gerakan_dudukdiantaraduasujud();
	    } else if (nama.equalsIgnoreCase("tahyat awal")) {
	    	gerakan_tahyatawal();
	    } else if (nama.equalsIgnoreCase("tahyat akhir")) {
	    	gerakan_tahyatakhir();
	    } else if (nama.equalsIgnoreCase("salam")) {
	    	gerakan_salam();
	    } else if (nama.equalsIgnoreCase("sujud syahwi")) {
	    	gerakan_sujudsyahwi();
	    } else if (nama.equalsIgnoreCase("subuh")) {
	    	subuh();
	    } else if (nama.equalsIgnoreCase("dzuhur")) {
	    	dzuhur();
	    } else if (nama.equalsIgnoreCase("ashar")) {
	    	ashar();
	    } else if (nama.equalsIgnoreCase("maghrib")) {
	    	maghrib();
	    } else if (nama.equalsIgnoreCase("isya")) {
	    	isya();
	    } else if (nama.equalsIgnoreCase("tasbih")) {
	    	tasbih();
	    } else if (nama.equalsIgnoreCase("idul fitri")) {
	    	idulfitri();
	    } else if (nama.equalsIgnoreCase("gerhana")) {
	    	gerhana();
	    } else if (nama.equalsIgnoreCase("jenazah")) {
	    	shalatjenazah();
	    }
	}
	
	public void PlaySound(String nama) {
		StopSound();
		int m6jrdf = getResources().getIdentifier(getPackageName() + ":raw/" + nama , null, null);
		mp = MediaPlayer.create(this,m6jrdf); 
		mp.start();
	}
	public void StopSound() {
		if (mp != null) {
			mp.release();
			mp = null;
		}
	}
	public void gerakan_takbir() {
		
	//	setContentView(R.layout.activity_gambar);
		

		
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanikhtidal_b);	
		image_content = (ImageView)findViewById(R.id.image_content);
		
		//bener
		Runnable lari = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
					pusing.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							gambar.setImageResource(R.drawable.gerakantakbir_a);
						}
					});
					Thread.sleep(1000);
					pusing.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.allahuakbar);
						}
					});
					Thread.sleep(5000);
					pusing.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							gambar.setImageResource(R.drawable.gerakantakbir_c);
						}
					});
					Thread.sleep(500);
					pusing.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							gambar.setImageResource(R.drawable.gerakanbaca_a);
						}
					});
					Thread.sleep(500);
					pusing.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							gambar.setImageResource(R.drawable.gerakanbaca_c);
						}
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
		};
		bingung.interrupt();
		bingung = null;
		bingung = new Thread(lari);
		bingung.start();
		//bener			
	}
	public void gerakan_rukuk() {
		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanbaca_a);
		//bener
		Runnable lari = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.allahuakbar);
						}
					});
					Thread.sleep(5000);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							gambar.setImageResource(R.drawable.gerakanrukuk_b);
							
						}
					});
					
					
					
					Thread.sleep(500);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							gambar.setImageResource(R.drawable.gerakanrukuk_b);
							PlaySound("bacaan_rukuk");
							image_content.setImageResource(R.drawable.bacaan_rukuk);
						}
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		bingung.interrupt();
		bingung = null;
		bingung = new Thread(lari);
		bingung.start();
		//bener
	}
	public void gerakan_ikhtidal() {
	//	setContentView(R.layout.activity_gambar);
		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanrukuk_b);
		//bener
		Runnable lari = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							gambar.setImageResource(R.drawable.gerakanrukuk_a);
						}
					});
					Thread.sleep(1000);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							gambar.setImageResource(R.drawable.gerakantakbir_a);
						}
					});
					Thread.sleep(500);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir_ikhtidal");gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
						}
					});
					Thread.sleep(7000);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							PlaySound("bacaan_ikhtidal");
							gambar.setImageResource(R.drawable.gerakanikhtidal_b);
							image_content.setImageResource(R.drawable.bacaan_ikhtidal);
						}
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		bingung.interrupt();
		bingung = null;
		bingung = new Thread(lari);
		bingung.start();
		//bener
	}
	public void gerakan_sujud() {
//		setContentView(R.layout.activity_gambar);
			image_content = (ImageView)findViewById(R.id.image_content);
			gambar = (ImageView)findViewById(R.id.gambar);
			gambar.setImageResource(R.drawable.gerakanikhtidal_b);
			//bener
			Runnable lari = new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					try {
						Thread.sleep(1000);
						pusing.post(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
						Thread.sleep(5000);
						pusing.post(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakansujud_c);
							}
						});
						Thread.sleep(500);
						pusing.post(new Runnable() {
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_sujud");
								gambar.setImageResource(R.drawable.gerakansujud_d);
								image_content.setImageResource(R.drawable.bacaan_sujud);
							}
						});
						} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};
			bingung.interrupt();
			bingung = null;
			bingung = new Thread(lari);
			bingung.start();
			//bener
		}
	public void gerakan_dudukdiantaraduasujud() {
		//setContentView(R.layout.activity_gambar);
		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakansujud_c);
		//bener
		Runnable lari = new Runnable() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Thread.sleep(1000);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
							image_content.setImageResource(R.drawable.allahuakbar);
						}
					});
					Thread.sleep(1000);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						}
					});
					Thread.sleep(5000);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
							PlaySound("duduk_2sujud");
							gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_d);
							image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
						}
					});
					Thread.sleep(17000);
					pusing.post(new Runnable() {
						@Override
						public void run() {
							// TODO Auto-generated method stub
						}
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		bingung.interrupt();
		bingung = null;
		bingung = new Thread(lari);
		bingung.start();
		//bener
	}
	public void gerakan_tahyatawal() {	
		
		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakansujud_c);
		
		Runnable lari = new Runnable() {
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
		
				try {
					Thread.sleep(1000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
							image_content.setImageResource(R.drawable.allahuakbar);
									
						}
					});
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatawal_a");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaantahyat_awal);
											
					}
				});
			Thread.sleep(25000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_c);
				}
			});
			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tahyatawal_b");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_e);
					image_content.setImageResource(R.drawable.bacaantahyatawal_b);

				}
			});
		} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
			
			}
		}
		};
		bingung.interrupt();
		bingung = null;
		bingung = new Thread(lari);
		bingung.start();
		//bener					
				
}
	public void gerakan_tahyatakhir() {	

		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakansujud_c);
//bener	
		Runnable lari = new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
		
				try {
					Thread.sleep(1000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
							image_content.setImageResource(R.drawable.allahuakbar);
						}
					});
				
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatawal_a");
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						image_content.setImageResource(R.drawable.bacaantahyat_awal);
					}
				});
			
			Thread.sleep(25000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.tahyatakhir_b);
				}
			});
			Thread.sleep(500);
			mHandler.post(new Runnable() {
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tahyatakhir_b");
					gambar.setImageResource(R.drawable.tahyatakhir_c);
					image_content.setImageResource(R.drawable.bacaantasyahud_akhir);
				}
			});
		} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	}
		}
				
		};
		bingung.interrupt();
		bingung = null;
		bingung = new Thread(lari);
		bingung.start();
		//bener			
}
	public void gerakan_salam() {

		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.tahyatakhir_a);

//bener	
		
	Runnable lari = new Runnable() {
		
			@Override
			public void run() {
				// TODO Auto-generated method stub                                        
		
				try {
					Thread.sleep(1000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							PlaySound("salam");
							gambar.setImageResource(R.drawable.gerakan_salamkanan);
							image_content.setImageResource(R.drawable.bacaan_salam);

						}
					});
				
		Thread.sleep(3000);
		mHandler.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				PlaySound("salam");
				gambar.setImageResource(R.drawable.gerakan_salamkiri);
				image_content.setImageResource(R.drawable.bacaan_salam);
			}
		});
	
		Thread.sleep(3000);
		mHandler.post(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				gambar.setImageResource(R.drawable.tahyatakhir_a);
	
			}
		});
	} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
	
		}
		}
		};
		bingung.interrupt();
		bingung = null;
		bingung = new Thread(lari);
		bingung.start();
		//bener				
	}		
	public void gerakan_sujudsyahwi() {
 
		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.tahyatakhir_a);
		image_content.setImageResource(R.drawable.bacaantahyat_awal);
		PlaySound("tahyatawal_a");
//bener	
	Runnable lari = new Runnable() {		

			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
				
				Thread.sleep(25000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatakhir_b");
						gambar.setImageResource(R.drawable.tahyatakhir_b);
						image_content.setImageResource(R.drawable.bacaantasyahud_akhir);
					}
				});
		
				Thread.sleep(54000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
	
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("sujud_sahwi");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujudsyahwi);
					}
				});
	
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
						
					}
				});
	
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("sujud_sahwi");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujudsyahwi);
					}
				});
	
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakan_salamkanan);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				});

				Thread.sleep(3000);
				mHandler.post(new Runnable() {
		
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakan_salamkiri);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				});

					Thread.sleep(3000);
					mHandler.post(new Runnable() {
		
						@Override
							public void run() {
							// TODO Auto-generated method stub
							gambar.setImageResource(R.drawable.tahyatakhir_a);
						}
					});
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

		}
		}
			
		};
		bingung.interrupt();
		bingung = null;
		bingung = new Thread(lari);
		bingung.start();
		//bener		
	}	
	public void subuh() {

		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanikhtidal_b);
		image_content.setImageResource(R.drawable.niat_subuh);
		PlaySound("niat_subuh");
//bener	
		Runnable lari = new Runnable() {				
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
				Thread.sleep(10000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});
				
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakantakbir_c);
				}
			});
		
			Thread.sleep(1000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("iftitah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.iftitah);
				}
			});
				Thread.sleep(50000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alfatiah");
						gambar.setImageResource(R.drawable.gerakanbaca_c);
						image_content.setImageResource(R.drawable.alfatiah);
					}
				});
			
				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("annass");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.surat_annas);
					}
				});
								
				Thread.sleep(40000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
								
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
								
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});
		
				Thread.sleep(16000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
								
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakantakbir_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});
			
				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						
					}
				});	

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_c);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});	
				
				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
				
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakansujud_c);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_d);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("duduk_2sujud");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_d);
					image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});
// Rakaat ke 2			
			
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("alfatiah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.alfatiah);
				}
			});
		
				 Thread.sleep(53000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alikhlas");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.alikhlas);
					}
				});

				Thread.sleep(25000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});

				Thread.sleep(16000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});
		
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});
						
				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});
		
				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				 Thread.sleep(17000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatawal_a");
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						image_content.setImageResource(R.drawable.bacaantahyat_awal);
					}
				});
				 Thread.sleep(27000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.tahyatakhir_b);
					}
				});

				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatakhir_b");
						gambar.setImageResource(R.drawable.tahyatakhir_c);
						image_content.setImageResource(R.drawable.bacaantasyahud_akhir);
					}
				});

				 Thread.sleep(57000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.tahyatakhir_a);
					}
				});

				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkanan);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				});

				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkiri);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				}); 

				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.tahyatakhir_a);
					}
				}); 
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		};
	bingung.interrupt();
	bingung = null;
	bingung = new Thread(lari);
	bingung.start();
	//bener		

}
	public void dzuhur() {

		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanikhtidal_b);
		image_content.setImageResource(R.drawable.niat_dzuhur);
		PlaySound("niat_dzuhur");
//bener	
Runnable lari = new Runnable() {	
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
				Thread.sleep(12000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);

				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakantakbir_c);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("iftitah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.iftitah);
				}
			});

				Thread.sleep(50000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alfatiah");
						gambar.setImageResource(R.drawable.gerakanbaca_c);
						image_content.setImageResource(R.drawable.alfatiah);
					}
				});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("annass");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.surat_annas);
					}
				});

				Thread.sleep(40000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});
			
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
				}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
					}
				});	

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_c);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});	

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakansujud_c);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_d);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("duduk_2sujud");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_d);
					image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});
						
	// Rakaat Ke-2
			
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("alfatiah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.alfatiah);
				}
			});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("alalaq");
						image_content.setImageResource(R.drawable.surat_alaq);
					}
			});
			
			Thread.sleep(85000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});
			
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				gambar.setImageResource(R.drawable.gerakanrukuk_a);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_rukuk");
					gambar.setImageResource(R.drawable.gerakanrukuk_b);
					image_content.setImageResource(R.drawable.bacaan_rukuk);
				}
			});

			Thread.sleep(15000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				gambar.setImageResource(R.drawable.gerakanrukuk_a);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakantakbir_a);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir_ikhtidal");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
				}
			});

			Thread.sleep(7000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_ikhtidal");
					gambar.setImageResource(R.drawable.gerakanikhtidal_b);
					image_content.setImageResource(R.drawable.bacaan_ikhtidal);
				}
			});

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("duduk_2sujud");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
					image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});

			 Thread.sleep(17000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tahyatawal_a");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
					image_content.setImageResource(R.drawable.bacaantahyat_awal);
				}
			});

			 Thread.sleep(25000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_c);
				}
			});

			 Thread.sleep(500);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tahyatawal_b");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_e);
					image_content.setImageResource(R.drawable.bacaantahyatawal_b);
				}
			});

//	Rakaat Ke-3

				Thread.sleep(16000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alfatiah");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.alfatiah);
					}
				});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});

				Thread.sleep(16000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
	
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});
	// Rakaat Ke-4

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
				}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("alfatiah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.alfatiah);
				}
			});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				 Thread.sleep(17000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatawal_a");
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						image_content.setImageResource(R.drawable.bacaantahyat_awal);
					}
				});

				 Thread.sleep(25000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.tahyatakhir_b);
					}
				});

				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatakhir_b");
						gambar.setImageResource(R.drawable.tahyatakhir_c);
						image_content.setImageResource(R.drawable.bacaantasyahud_akhir);
					}
				});

				 Thread.sleep(57000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.tahyatakhir_a);
					}
				});

				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkanan);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				});

				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkiri);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				}); 

				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.tahyatakhir_a);
					}
				}); 
			 }  catch(InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		};
	bingung.interrupt();
	bingung = null;
	bingung = new Thread(lari);
	bingung.start();
	//bener		

}
	public void ashar() {

		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanikhtidal_b);
		image_content.setImageResource(R.drawable.niat_ashar);
		PlaySound("niat_ashar");
//bener	
		Runnable lari = new Runnable() {	
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
				Thread.sleep(10000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);

				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakantakbir_c);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("iftitah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.iftitah);
				}
			});

				Thread.sleep(50000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alfatiah");
						gambar.setImageResource(R.drawable.gerakanbaca_c);
						image_content.setImageResource(R.drawable.alfatiah);
					}
				});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("annass");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.surat_annas);
					}
				});

				Thread.sleep(40000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});
			
				Thread.sleep(16000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
				}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
					}
				});	

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_c);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});	

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakansujud_c);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_d);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("duduk_2sujud");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_d);
					image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});
						
	// Rakaat Ke-2
			
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("alfatiah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.alfatiah);
				}
			});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("alalaq");
						image_content.setImageResource(R.drawable.surat_alaq);
					}
			});
			
			Thread.sleep(81000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});
			
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				gambar.setImageResource(R.drawable.gerakanrukuk_a);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_rukuk");
					gambar.setImageResource(R.drawable.gerakanrukuk_b);
					image_content.setImageResource(R.drawable.bacaan_rukuk);
				}
			});

			Thread.sleep(16000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				gambar.setImageResource(R.drawable.gerakanrukuk_a);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakantakbir_a);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir_ikhtidal");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
				}
			});

			Thread.sleep(7000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_ikhtidal");
					gambar.setImageResource(R.drawable.gerakanikhtidal_b);
					image_content.setImageResource(R.drawable.bacaan_ikhtidal);
				}
			});

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("duduk_2sujud");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
					image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});

			 Thread.sleep(17000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tahyatawal_a");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
					image_content.setImageResource(R.drawable.bacaantahyat_awal);
				}
			});

			 Thread.sleep(25000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_c);
				}
			});

			 Thread.sleep(500);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tahyatawal_b");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_e);
					image_content.setImageResource(R.drawable.bacaantahyatawal_b);
				}
			});

//	Rakaat Ke-3

				Thread.sleep(20000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alfatiah");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.alfatiah);
					}
				});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});

				Thread.sleep(16000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
	
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});
	// Rakaat Ke-4

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
				}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("alfatiah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.alfatiah);
				}
			});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});

				Thread.sleep(16000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				 Thread.sleep(17000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatawal_a");
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						image_content.setImageResource(R.drawable.bacaantahyat_awal);
					}
				});

				 Thread.sleep(25000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.tahyatakhir_b);
					}
				});

				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatakhir_b");
						gambar.setImageResource(R.drawable.tahyatakhir_c);
						image_content.setImageResource(R.drawable.bacaantasyahud_akhir);
					}
				});

				 Thread.sleep(57000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.tahyatakhir_a);
					}
				});

				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkanan);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				});

				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkiri);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				}); 

				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.tahyatakhir_a);
					}
				}); 
			 }  catch(InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		};
	bingung.interrupt();
	bingung = null;
	bingung = new Thread(lari);
	bingung.start();
	//bener		

}                    
	public  void maghrib() {

		
		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanikhtidal_b);
		image_content.setImageResource(R.drawable.niat_maghrib);
		PlaySound("niat_maghrib");
//bener	
Runnable lari = new Runnable() {				
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
				Thread.sleep(12000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub

						gambar.setImageResource(R.drawable.gerakantakbir_a);

					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);

				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub

					gambar.setImageResource(R.drawable.gerakantakbir_c);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("iftitah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.iftitah);
	
				}
			});

				Thread.sleep(50000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alfatiah");
						gambar.setImageResource(R.drawable.gerakanbaca_c);
						image_content.setImageResource(R.drawable.alfatiah);
					}
				});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("annass");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.surat_annas);
					}
				});

				Thread.sleep(40000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});

				Thread.sleep(16000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakantakbir_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						
					}
				});	

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_c);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});	
				

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakansujud_c);
						
					}
				});
				

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_d);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
					
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("duduk_2sujud");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_d);
					image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
				}
			});
			
			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});
		
			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});

	// Rakaat Ke-2

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("alfatiah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.alfatiah);

				}
			});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alalaq");
						image_content.setImageResource(R.drawable.surat_alaq);
					}
				});

			Thread.sleep(81000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});
		
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_rukuk");
					gambar.setImageResource(R.drawable.gerakanrukuk_b);
					image_content.setImageResource(R.drawable.bacaan_rukuk);
				}
			});

			Thread.sleep(16000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					gambar.setImageResource(R.drawable.gerakantakbir_a);

				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir_ikhtidal");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
				}
			});

			Thread.sleep(7000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_ikhtidal");
					gambar.setImageResource(R.drawable.gerakanikhtidal_b);
					image_content.setImageResource(R.drawable.bacaan_ikhtidal);
				}
			});
	
				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("duduk_2sujud");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
					image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});

			 Thread.sleep(17000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tahyatawal_a");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
					image_content.setImageResource(R.drawable.bacaantahyat_awal);
				}
			});

			 Thread.sleep(25000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_c);
					
				}
			});

			 Thread.sleep(500);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tahyatawal_b");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_e);
					image_content.setImageResource(R.drawable.bacaantahyatawal_b);
				}
			});

	// Rakaat Ke-3

				Thread.sleep(20000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("alfatiah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.alfatiah);

				}
			});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakantakbir_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});

				Thread.sleep(16000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakantakbir_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});
				

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				 Thread.sleep(17000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatawal_a");
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						image_content.setImageResource(R.drawable.bacaantahyat_awal);
					}
				});

				 Thread.sleep(25000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.tahyatakhir_b);
						
					}
				});

				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatakhir_b");
						gambar.setImageResource(R.drawable.tahyatakhir_c);
						image_content.setImageResource(R.drawable.bacaantasyahud_akhir);
					}
				});

				 Thread.sleep(57000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						
					}
				});

				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkanan);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				});

				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkiri);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				}); 

				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						
					}
				}); 
			 }  catch(InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
			}
		};
	bingung.interrupt();
	bingung = null;
	bingung = new Thread(lari);
	bingung.start();
	//bener		
}
	public void isya() {

		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanikhtidal_b);
		image_content.setImageResource(R.drawable.niat_isya);
		PlaySound("niat_isya");
//bener	
		Runnable lari = new Runnable() {	
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);

				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakantakbir_c);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("iftitah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.iftitah);
				}
			});

				Thread.sleep(50000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alfatiah");
						gambar.setImageResource(R.drawable.gerakanbaca_c);
						image_content.setImageResource(R.drawable.alfatiah);
					}
				});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("annass");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.surat_annas);
					}
				});

				Thread.sleep(40000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});
			
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
				}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
					}
				});	

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_c);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});	

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakansujud_c);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_d);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("duduk_2sujud");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_d);
					image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});
						
	// Rakaat Ke-2
			
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("alfatiah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.alfatiah);
				}
			});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("alalaq");
						image_content.setImageResource(R.drawable.surat_alaq);
					}
			});
			
			Thread.sleep(85000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});
			
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				gambar.setImageResource(R.drawable.gerakanrukuk_a);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_rukuk");
					gambar.setImageResource(R.drawable.gerakanrukuk_b);
					image_content.setImageResource(R.drawable.bacaan_rukuk);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				gambar.setImageResource(R.drawable.gerakanrukuk_a);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakantakbir_a);
				}
			});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir_ikhtidal");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
				}
			});

			Thread.sleep(7000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_ikhtidal");
					gambar.setImageResource(R.drawable.gerakanikhtidal_b);
					image_content.setImageResource(R.drawable.bacaan_ikhtidal);
				}
			});

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("duduk_2sujud");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
					image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
				}
			});

			Thread.sleep(17000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});

			 Thread.sleep(17000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tahyatawal_a");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
					image_content.setImageResource(R.drawable.bacaantahyat_awal);
				}
			});

			 Thread.sleep(25000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_c);
				}
			});

			 Thread.sleep(500);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tahyatawal_b");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_e);
					image_content.setImageResource(R.drawable.bacaantahyatawal_b);
				}
			});

//	Rakaat Ke-3

				Thread.sleep(20000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alfatiah");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.alfatiah);
					}
				});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
	
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});
	// Rakaat Ke-4

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
				}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					PlaySound("alfatiah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.alfatiah);
				}
			});

				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakantakbir_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});

				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});

				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					}
				});

				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});

				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});

				 Thread.sleep(17000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});

				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatawal_a");
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						image_content.setImageResource(R.drawable.bacaantahyat_awal);
					}
				});

				 Thread.sleep(25000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.tahyatakhir_b);
					}
				});

				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatakhir_b");
						gambar.setImageResource(R.drawable.tahyatakhir_c);
						image_content.setImageResource(R.drawable.bacaantasyahud_akhir);
					}
				});

				 Thread.sleep(57000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					gambar.setImageResource(R.drawable.tahyatakhir_a);
					}
				});

				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkanan);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				});

				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkiri);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				}); 

				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						gambar.setImageResource(R.drawable.tahyatakhir_a);
					}
				}); 
			 }  catch(InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		};
	bingung.interrupt();
	bingung = null;
	bingung = new Thread(lari);
	bingung.start();
	//bener		

}                    
	private void tasbih() {
		
		
		View b = findViewById(R.id.buttonInfo);
    	b.setVisibility(View.VISIBLE);
		
		
		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanikhtidal_b);
		image_content.setImageResource(R.drawable.niat_tasbih);
		PlaySound("niat_tasbih");
//bener	
		Runnable lari = new Runnable() {	
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					
					Thread.sleep(9000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
					
							gambar.setImageResource(R.drawable.gerakantakbir_a);
						
						}
					});
				
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
					
							gambar.setImageResource(R.drawable.gerakantakbir_b);
					
						}
					});
					
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_c);
							image_content.setImageResource(R.drawable.allahuakbar);
						}
					});
				
					Thread.sleep(5000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("iftitah");
							gambar.setImageResource(R.drawable.gerakanbaca_a);
							image_content.setImageResource(R.drawable.iftitah);
				
						}
					});
			
					Thread.sleep(50000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("alfatiah");
							gambar.setImageResource(R.drawable.gerakanbaca_c);
							image_content.setImageResource(R.drawable.alfatiah);
						}
					});
				
						Thread.sleep(53000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								PlaySound("alfalaq");
								gambar.setImageResource(R.drawable.gerakanbaca_a);
								image_content.setImageResource(R.drawable.alfalaq);
							}
						});
				
					Thread.sleep(33000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tasbih");
							image_content.setImageResource(R.drawable.tasbih_a);
						}
					});
		
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakantakbir_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
		
						Thread.sleep(5000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
		
						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_rukuk");
								gambar.setImageResource(R.drawable.gerakanrukuk_b);
								image_content.setImageResource(R.drawable.bacaan_rukuk);
								
							}
						});
		
						Thread.sleep(16000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});

						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakantakbir_a);
								
							}
						});
	
						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir_ikhtidal");
								gambar.setImageResource(R.drawable.gerakantakbir_b);
								image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
							}
						});

						Thread.sleep(7000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanikhtidal_b);
								
							}
						});	

						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_ikhtidal");
								gambar.setImageResource(R.drawable.gerakanikhtidal_c);
								image_content.setImageResource(R.drawable.bacaan_ikhtidal);
							}
						});	

						Thread.sleep(15000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});	

						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
		
							Thread.sleep(500);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("takbir");
									gambar.setImageResource(R.drawable.gerakansujud_b);
									image_content.setImageResource(R.drawable.allahuakbar);
								}
							});

						    Thread.sleep(5000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									gambar.setImageResource(R.drawable.gerakansujud_c);
									
								}
							});

						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_sujud");
								gambar.setImageResource(R.drawable.gerakansujud_d);
								image_content.setImageResource(R.drawable.bacaan_sujud);
							}
						});

						Thread.sleep(17000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});

						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});

							Thread.sleep(5000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
									
								}
							});
			
							Thread.sleep(500);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("duduk_2sujud");
									gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_d);
									image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
								}
							});
	
							Thread.sleep(17000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("tasbih");
									image_content.setImageResource(R.drawable.tasbih_b);
								}
							});

						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});

						 Thread.sleep(5000);
						 mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_sujud");
								gambar.setImageResource(R.drawable.gerakansujud_c);
								image_content.setImageResource(R.drawable.bacaan_sujud);
							}
						});

						 Thread.sleep(17000);
						 mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});

						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});

						Thread.sleep(5000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});
	
			// Rakaat Ke-2
		
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
		
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
													
							}
						});
	
								Thread.sleep(500);
								mHandler.post(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										
										PlaySound("takbir");
										gambar.setImageResource(R.drawable.gerakantakbir_a);
										image_content.setImageResource(R.drawable.allahuakbar);
													
									}
								});

								Thread.sleep(5000);
								mHandler.post(new Runnable() {
						
									@Override
									public void run() {
										// TODO Auto-generated method stub
							
										PlaySound("alfatiah");
										gambar.setImageResource(R.drawable.gerakanbaca_a);
										image_content.setImageResource(R.drawable.alfatiah);
							
									}						
								});
	
							Thread.sleep(53000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("alalaq");
									image_content.setImageResource(R.drawable.surat_alaq);
								}
							});

							Thread.sleep(85000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("tasbih");
									image_content.setImageResource(R.drawable.tasbih_a);
								}
							});
	
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakantakbir_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
						
	
						Thread.sleep(5000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
	
						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_rukuk");
								gambar.setImageResource(R.drawable.gerakanrukuk_b);
								image_content.setImageResource(R.drawable.bacaan_rukuk);
							}
						});

						Thread.sleep(16000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							
							}
						});
	
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
	
						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakantakbir_a);
								
							}
						});

						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir_ikhtidal");
								gambar.setImageResource(R.drawable.gerakantakbir_b);
								image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
							}
						});
	
						Thread.sleep(7000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_ikhtidal");
								gambar.setImageResource(R.drawable.gerakanikhtidal_b);
								image_content.setImageResource(R.drawable.bacaan_ikhtidal);
							}
						});	

						Thread.sleep(15000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});	

						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
	
							Thread.sleep(500);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("takbir");
									gambar.setImageResource(R.drawable.gerakansujud_b);
									image_content.setImageResource(R.drawable.allahuakbar);
								}
							});

						    Thread.sleep(5000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("bacaan_sujud");
									gambar.setImageResource(R.drawable.gerakansujud_c);
									image_content.setImageResource(R.drawable.bacaan_sujud);
								}
							});
	
						Thread.sleep(17000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});
	
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
			
							Thread.sleep(5000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("duduk_2sujud");
									gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
									image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
								}
							});

							Thread.sleep(17000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("tasbih");
									image_content.setImageResource(R.drawable.tasbih_b);
								}
							});

						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});

						 Thread.sleep(5000);
						 mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_sujud");
								gambar.setImageResource(R.drawable.gerakansujud_c);
								image_content.setImageResource(R.drawable.bacaan_sujud);
							}
						});
	
						 Thread.sleep(17000);
						 mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});

						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
						Thread.sleep(5000);
						mHandler.post(new Runnable() {
						
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});

			// Rakaat Ke-3
	
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
	
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
											
							}
						});

								Thread.sleep(500);
								mHandler.post(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										
										PlaySound("takbir");
										gambar.setImageResource(R.drawable.gerakantakbir_a);
										image_content.setImageResource(R.drawable.allahuakbar);
		
									}
								});

							Thread.sleep(5000);
							mHandler.post(new Runnable() {
						
								@Override
								public void run() {
									// TODO Auto-generated method stub
							
									PlaySound("alfatiah");
									gambar.setImageResource(R.drawable.gerakanbaca_a);
									image_content.setImageResource(R.drawable.alfatiah);
								
								}
							});
	
							Thread.sleep(53000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("alikhlas");
									image_content.setImageResource(R.drawable.alikhlas);
								}
							});
									
							Thread.sleep(25000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("tasbih");
									image_content.setImageResource(R.drawable.tasbih_a);
								}
							});
				
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakantakbir_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
			
						Thread.sleep(5000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
			
						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_rukuk");
								gambar.setImageResource(R.drawable.gerakanrukuk_b);
								image_content.setImageResource(R.drawable.bacaan_rukuk);
							}
						});
			
						Thread.sleep(17000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							
							}
						});
		
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
		
						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakantakbir_a);
								
							}
						});
		
						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir_ikhtidal");
								gambar.setImageResource(R.drawable.gerakantakbir_b);
								image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
							}
						});
		
						Thread.sleep(7000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_ikhtidal");
								gambar.setImageResource(R.drawable.gerakanikhtidal_b);
								image_content.setImageResource(R.drawable.bacaan_ikhtidal);
							}
						});	
		
						Thread.sleep(13000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});	
	
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
			
							Thread.sleep(500);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("takbir");
									gambar.setImageResource(R.drawable.gerakansujud_b);
									image_content.setImageResource(R.drawable.allahuakbar);
								}
							});
						
						    Thread.sleep(5000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("bacaan_sujud");
									gambar.setImageResource(R.drawable.gerakansujud_c);
									image_content.setImageResource(R.drawable.bacaan_sujud);
								}
							});
		
						Thread.sleep(17000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});
			
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
				
							Thread.sleep(5000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("duduk_2sujud");
									gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
									image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
								}
							});
					
							Thread.sleep(17000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("tasbih");
									image_content.setImageResource(R.drawable.tasbih_b);
								}
							});
		
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
	
						 Thread.sleep(5000);
						 mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_sujud");
								gambar.setImageResource(R.drawable.gerakansujud_c);
								image_content.setImageResource(R.drawable.bacaan_sujud);
							}
						});
											
						 Thread.sleep(17000);
						 mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});
										
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
					
						Thread.sleep(5000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});
				
			// Rakaat Ke-4
			
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
						
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
															
							}
						});
						
								Thread.sleep(500);
								mHandler.post(new Runnable() {
									
									@Override
									public void run() {
										// TODO Auto-generated method stub
										
									PlaySound("takbir");
									gambar.setImageResource(R.drawable.gerakantakbir_a);
									image_content.setImageResource(R.drawable.allahuakbar);
						
									}
								});
					
							Thread.sleep(5000);
							mHandler.post(new Runnable() {
						
								@Override
								public void run() {
									// TODO Auto-generated method stub
							
									PlaySound("alfatiah");
									gambar.setImageResource(R.drawable.gerakanbaca_a);
									image_content.setImageResource(R.drawable.alfatiah);
					}
					});
				
							Thread.sleep(53000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("annass");
									gambar.setImageResource(R.drawable.gerakanbaca_a);
									image_content.setImageResource(R.drawable.surat_annas);
								}
							});
				
							Thread.sleep(40000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("tasbih");
									image_content.setImageResource(R.drawable.tasbih_a);
								}
							});
				
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakantakbir_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
				
						Thread.sleep(5000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
			
						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_rukuk");
								gambar.setImageResource(R.drawable.gerakanrukuk_b);
								image_content.setImageResource(R.drawable.bacaan_rukuk);
							}
						});
			
						Thread.sleep(17000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							
							}
						});
				
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
				
						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakantakbir_a);
								
							}
						});
				
						Thread.sleep(500);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir_ikhtidal");
								gambar.setImageResource(R.drawable.gerakantakbir_b);
								image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
							}
						});
			
						Thread.sleep(7000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_ikhtidal");
								gambar.setImageResource(R.drawable.gerakanikhtidal_b);
								image_content.setImageResource(R.drawable.bacaan_ikhtidal);
							}
						});	
				
						Thread.sleep(15000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});	
				
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								gambar.setImageResource(R.drawable.gerakanrukuk_a);
								
							}
						});
						
							Thread.sleep(500);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("takbir");
									gambar.setImageResource(R.drawable.gerakansujud_b);
									image_content.setImageResource(R.drawable.allahuakbar);
								}
							});
						
						    Thread.sleep(5000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("bacaan_sujud");
									gambar.setImageResource(R.drawable.gerakansujud_c);
									image_content.setImageResource(R.drawable.bacaan_sujud);
									
								}
							});
										
						Thread.sleep(17000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});
				
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
						
							Thread.sleep(5000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("duduk_2sujud");
									gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
									image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
									
								}
							});
						
							Thread.sleep(17000);
							mHandler.post(new Runnable() {
								
								@Override
								public void run() {
									// TODO Auto-generated method stub
									
									PlaySound("tasbih");
									image_content.setImageResource(R.drawable.tasbih_b);
								}
							});
				
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
					
						 Thread.sleep(5000);
						 mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("bacaan_sujud");
								gambar.setImageResource(R.drawable.gerakansujud_c);
								image_content.setImageResource(R.drawable.bacaan_sujud);
							}
						});
					
						 Thread.sleep(17000);
						 mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("tasbih");
								image_content.setImageResource(R.drawable.tasbih_b);
							}
						});
				
						Thread.sleep(4000);
						mHandler.post(new Runnable() {
							
							@Override
							public void run() {
								// TODO Auto-generated method stub
								
								PlaySound("takbir");
								gambar.setImageResource(R.drawable.gerakansujud_b);
								image_content.setImageResource(R.drawable.allahuakbar);
							}
						});
				
					 Thread.sleep(5000);
					 mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tahyatawal_a");
							gambar.setImageResource(R.drawable.tahyatakhir_a);
							image_content.setImageResource(R.drawable.bacaantahyat_awal);
						}
					});
				
					 Thread.sleep(25000);
					 mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							gambar.setImageResource(R.drawable.tahyatakhir_b);
							
						}
					});
				
					 Thread.sleep(500);
					 mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tahyatakhir_b");
							gambar.setImageResource(R.drawable.tahyatakhir_c);
							image_content.setImageResource(R.drawable.bacaantasyahud_akhir);
						}
					});
			
					 Thread.sleep(57000);
					 mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tasbih");
							gambar.setImageResource(R.drawable.tahyatakhir_a);
							image_content.setImageResource(R.drawable.tasbih_b);
						}
					});
		
					 Thread.sleep(4000);
					 mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("salam");
							gambar.setImageResource(R.drawable.gerakan_salamkanan);
							image_content.setImageResource(R.drawable.bacaan_salam);
						}
					});
		
					 Thread.sleep(3000);
					 mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("salam");
							gambar.setImageResource(R.drawable.gerakan_salamkiri);
							image_content.setImageResource(R.drawable.bacaan_salam);
						}
					}); 
			
					 Thread.sleep(3000);
					 mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							gambar.setImageResource(R.drawable.tahyatakhir_a);
							
						}
					}); 
				 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
		
			}
		};
			bingung.interrupt();
			bingung = null;
			bingung = new Thread(lari);
			bingung.start();
//bener		

			
		
	}
	public void idulfitri(){
		
		View b = findViewById(R.id.buttonInfo);
    	b.setVisibility(View.VISIBLE);
	
		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanikhtidal_b);
		image_content.setImageResource(R.drawable.niat_idulfitri);
		PlaySound("niat_fitri");
//bener	
		Runnable lari = new Runnable() {		
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					
					Thread.sleep(6000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
					
							gambar.setImageResource(R.drawable.gerakantakbir_a);
					
						}
					});
				
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.allahuakbar);
					
						}
					});
				
					Thread.sleep(5000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
						
							gambar.setImageResource(R.drawable.gerakantakbir_c);
							
							}
					});
			
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							gambar.setImageResource(R.drawable.gerakanbaca_a);
							
							}
					});
				
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tasbih");
							gambar.setImageResource(R.drawable.gerakanbaca_c);
							image_content.setImageResource(R.drawable.tasbih);
							}
					});
				
					Thread.sleep(4000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.allahuakbar);
					
						}
					});
			
					Thread.sleep(5000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tasbih");
							gambar.setImageResource(R.drawable.gerakanbaca_a);
							image_content.setImageResource(R.drawable.tasbih);
							
						}
					});
			
					Thread.sleep(4000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.allahuakbar);
						
						}
					});
				
					Thread.sleep(5000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tasbih");
							gambar.setImageResource(R.drawable.gerakanbaca_a);
							image_content.setImageResource(R.drawable.tasbih);
							
						}
					});
				
					Thread.sleep(4000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.allahuakbar);
					
						}
					});
			
					Thread.sleep(5000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tasbih");
							gambar.setImageResource(R.drawable.gerakanbaca_a);
							image_content.setImageResource(R.drawable.tasbih);
							
						}
					});
			
					Thread.sleep(4000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.allahuakbar);
						
						}
					});
			
					Thread.sleep(5000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tasbih");
							gambar.setImageResource(R.drawable.gerakanbaca_a);
							image_content.setImageResource(R.drawable.tasbih);
							
						}
					});
				
					Thread.sleep(4000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.allahuakbar);
					
						}
					});
			
					Thread.sleep(5000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tasbih");
							gambar.setImageResource(R.drawable.gerakanbaca_a);
							image_content.setImageResource(R.drawable.tasbih);
							
						}
					});
			
					Thread.sleep(4000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.allahuakbar);
					
						}
					});
				
					Thread.sleep(5000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("tasbih");
							gambar.setImageResource(R.drawable.gerakanbaca_a);
							image_content.setImageResource(R.drawable.tasbih);
							
						}
					});
				
					Thread.sleep(4000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("alfatiah");
							gambar.setImageResource(R.drawable.gerakanbaca_c);
							image_content.setImageResource(R.drawable.alfatiah);
						}
					});
				
					Thread.sleep(53000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("annass");
							gambar.setImageResource(R.drawable.gerakanbaca_a);
							image_content.setImageResource(R.drawable.surat_annas);
						}
					});
				
					Thread.sleep(40000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.allahuakbar);
						}
					});
				
					Thread.sleep(5000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							gambar.setImageResource(R.drawable.gerakanrukuk_a);
							
						}
					});
			
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("bacaan_rukuk");
							gambar.setImageResource(R.drawable.gerakanrukuk_b);
							image_content.setImageResource(R.drawable.bacaan_rukuk);
						}
					});
			
					Thread.sleep(17000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							gambar.setImageResource(R.drawable.gerakanrukuk_a);
							
						}
					});
				
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							gambar.setImageResource(R.drawable.gerakantakbir_a);
							
						}
					});
			
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir_ikhtidal");
							gambar.setImageResource(R.drawable.gerakantakbir_b);
							image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
						}
					});
				
					Thread.sleep(7000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							gambar.setImageResource(R.drawable.gerakanikhtidal_b);
							
						}
					});	
					
				
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("bacaan_ikhtidal");
							gambar.setImageResource(R.drawable.gerakanikhtidal_c);
							image_content.setImageResource(R.drawable.bacaan_ikhtidal);
						}
					});	
				
					Thread.sleep(15000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							gambar.setImageResource(R.drawable.gerakanrukuk_a);
							
						}
					});
				
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("takbir");
							gambar.setImageResource(R.drawable.gerakansujud_b);
							image_content.setImageResource(R.drawable.allahuakbar);
						}
					});
				
					Thread.sleep(5000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							gambar.setImageResource(R.drawable.gerakansujud_c);
							
						}
					});
				
					Thread.sleep(500);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
							
							PlaySound("bacaan_sujud");
							gambar.setImageResource(R.drawable.gerakansujud_d);
							image_content.setImageResource(R.drawable.bacaan_sujud);
						}
					});
				
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						
					}
				});
		
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_d);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});
			
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});
			
				Thread.sleep(14000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tasbih");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.tasbih);
					
				}
			});
		
			Thread.sleep(4000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
			
				}
			});
	
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tasbih");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.tasbih);
					
				}
			});
	
			Thread.sleep(4000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
			
				}
			});
		
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tasbih");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.tasbih);
					
				}
			});
	
			Thread.sleep(4000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				
				}
			});
		
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tasbih");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.tasbih);
					
				}
			});
		
			Thread.sleep(4000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				
				}
			});
		
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("tasbih");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.tasbih);
					
				}
			});
		
			 Thread.sleep(4000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("alfatiah");
					image_content.setImageResource(R.drawable.alfatiah);
				
				}
			});
		
			 Thread.sleep(53000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("annass");
					image_content.setImageResource(R.drawable.surat_annas);
				
				}
			});
		 
				Thread.sleep(40000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakantakbir_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});
			
				Thread.sleep(16000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakantakbir_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});
			
				Thread.sleep(7000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});
			
				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});
			
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
		
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});
			
				Thread.sleep(17000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});
			
				 Thread.sleep(17000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatawal_a");
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						image_content.setImageResource(R.drawable.bacaantahyat_awal);
					}
				});
			
				 Thread.sleep(25000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.tahyatakhir_b);
						
					}
				});
			
				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatakhir_b");
						gambar.setImageResource(R.drawable.tahyatakhir_c);
						image_content.setImageResource(R.drawable.bacaantasyahud_akhir);
					}
				});
			
				 Thread.sleep(57000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						
					}
				});
			 
				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkanan);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				});
			 
				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkiri);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				}); 
			
				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						
					}
				}); 
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	 	}
	
	};
			bingung.interrupt();
			bingung = null;
			bingung = new Thread(lari);
			bingung.start();
//bener		

	}
	public void gerhana() {
		
		View b = findViewById(R.id.buttonInfo);
    	b.setVisibility(View.VISIBLE);
		
		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanikhtidal_b);
		image_content.setImageResource(R.drawable.niat_imamgerhana);
		PlaySound("niat_gerhana");
//bener	
		Runnable lari = new Runnable() {	
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
				Thread.sleep(12000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakantakbir_a);
						
					}
				});
			
			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakantakbir_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				
				}
			});
		
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
				
					gambar.setImageResource(R.drawable.gerakantakbir_c);
				
				}
			});
		
			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("iftitah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.iftitah);
				
				}
			});
		
				Thread.sleep(47000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alfatiah");
						gambar.setImageResource(R.drawable.gerakanbaca_c);
						image_content.setImageResource(R.drawable.alfatiah);
					}
				});
			
				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("albaqarah_a");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.albaqarah_a);
					}
				});
			
				Thread.sleep(250000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("albaqarah_b");
						image_content.setImageResource(R.drawable.albaqarah_b);
					}
				});
			
				Thread.sleep(328000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
					
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});
			
				Thread.sleep(13000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakantakbir_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});
			
				Thread.sleep(6000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						
					}
				});	
				
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_c);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});	
				
			
				Thread.sleep(10000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakansujud_c);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_d);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});
			
			Thread.sleep(14000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});
		
			Thread.sleep(5000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
					
				}
			});
		
			Thread.sleep(500);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("duduk_2sujud");
					gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_d);
					image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
				}
			});
		
			Thread.sleep(15000);
			mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("takbir");
					gambar.setImageResource(R.drawable.gerakansujud_b);
					image_content.setImageResource(R.drawable.allahuakbar);
				}
			});
		
			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("bacaan_sujud");
					gambar.setImageResource(R.drawable.gerakansujud_c);
					image_content.setImageResource(R.drawable.bacaan_sujud);
				}
			});
		
				Thread.sleep(14000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
		
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
			 Thread.sleep(5000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("alfatiah");
					gambar.setImageResource(R.drawable.gerakanbaca_a);
					image_content.setImageResource(R.drawable.alfatiah);
				
				}
			});
		
			 Thread.sleep(53000);
			 mHandler.post(new Runnable() {
				
				@Override
				public void run() {
					// TODO Auto-generated method stub
					
					PlaySound("alikhlas");
					image_content.setImageResource(R.drawable.alikhlas);
			
				}
			});
	
				Thread.sleep(20000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakantakbir_a);
						
					}
				});
	
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
	
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
		
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_rukuk");
						gambar.setImageResource(R.drawable.gerakanrukuk_b);
						image_content.setImageResource(R.drawable.bacaan_rukuk);
					}
				});
		
				Thread.sleep(13000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakantakbir_a);
						
					}
				});
	
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir_ikhtidal");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.bacaantakbir_ikhtidal);
					}
				});
		
				Thread.sleep(6000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_ikhtidal");
						gambar.setImageResource(R.drawable.gerakanikhtidal_b);
						image_content.setImageResource(R.drawable.bacaan_ikhtidal);
					}
				});
		
				Thread.sleep(10000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanrukuk_a);
						
					}
				});
		
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
		
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});
			
				Thread.sleep(14000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_a);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
		
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("duduk_2sujud");
						gambar.setImageResource(R.drawable.gerakandudukdiantarasujud_b);
						image_content.setImageResource(R.drawable.bacaan_diantaraduasujud);
					}
				});
			
				Thread.sleep(15000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("bacaan_sujud");
						gambar.setImageResource(R.drawable.gerakansujud_c);
						image_content.setImageResource(R.drawable.bacaan_sujud);
					}
				});
			
				 Thread.sleep(14000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakansujud_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					}
				});
			
				 Thread.sleep(5000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatawal_a");
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						image_content.setImageResource(R.drawable.bacaantahyat_awal);
					}
				});
			
				 Thread.sleep(23000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.tahyatakhir_b);
						
					}
				});
			
				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("tahyatakhir_b");
						gambar.setImageResource(R.drawable.tahyatakhir_c);
						image_content.setImageResource(R.drawable.bacaantasyahud_akhir);
					}
				});
			
				 Thread.sleep(54000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						
					}
				});
			
				 Thread.sleep(500);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkanan);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				});
			
				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");
						gambar.setImageResource(R.drawable.gerakan_salamkiri);
						image_content.setImageResource(R.drawable.bacaan_salam);
					}
				}); 
			
				 Thread.sleep(3000);
				 mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.tahyatakhir_a);
						
					}
				}); 
			 } catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			}
		};
			bingung.interrupt();
			bingung = null;
			bingung = new Thread(lari);
			bingung.start();
//bener		
	}	
	public void shalatjenazah() {

		View b = findViewById(R.id.buttonInfo);
    	b.setVisibility(View.VISIBLE);
		
		image_content = (ImageView)findViewById(R.id.image_content);
		gambar = (ImageView)findViewById(R.id.gambar);
		gambar.setImageResource(R.drawable.gerakanikhtidal_b);
		image_content.setImageResource(R.drawable.niat_jenazah);
		PlaySound("niat_jenazah");
//bener	
		Runnable lari = new Runnable() {	
		
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					Thread.sleep(12000);
					mHandler.post(new Runnable() {
						
						@Override
						public void run() {
							// TODO Auto-generated method stub
						
							gambar.setImageResource(R.drawable.gerakantakbir_a);
						
						}
					});
				
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
				
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
					
						gambar.setImageResource(R.drawable.gerakantakbir_c);
					
					}
				});
			
				Thread.sleep(500);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("alfatiah");
						gambar.setImageResource(R.drawable.gerakanbaca_c);
						image_content.setImageResource(R.drawable.alfatiah);
					}
				});
			
				Thread.sleep(53000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("sallawat");	
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.sallawat);
					
					}
				});
			
				Thread.sleep(30000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbirtiga_jenazah");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.takbirketiga_jenazah);
					
					}
				});
			
				Thread.sleep(8000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbir");
						gambar.setImageResource(R.drawable.gerakantakbir_b);
						image_content.setImageResource(R.drawable.allahuakbar);
					
					}
				});
			
				Thread.sleep(5000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("takbirempat_jenazah");
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						image_content.setImageResource(R.drawable.takbirempat_jenazah);
					
					}
				});
			
				Thread.sleep(12000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");						
						gambar.setImageResource(R.drawable.salamjenazah_kanan);
						image_content.setImageResource(R.drawable.bacaan_salam);
					
					}
				});
			
				Thread.sleep(3000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						PlaySound("salam");						
						gambar.setImageResource(R.drawable.salamjenazah_kiri);
						image_content.setImageResource(R.drawable.bacaan_salam);
					
					}
				});
		
				Thread.sleep(3000);
				mHandler.post(new Runnable() {
					
					@Override
					public void run() {
						// TODO Auto-generated method stub
						
						gambar.setImageResource(R.drawable.gerakanbaca_a);
						
					
					}
				});
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			} 
			}
		
	};
			bingung.interrupt();
			bingung = null;
			bingung = new Thread(lari);
			bingung.start();
//bener		

		}
	
	
}


